import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class TCP_HTTP {
  public static void main(String[] args) {
    // serverのdomainに定数として保存
    String serverName = "www.google.com";
    // port 番号を80番として定数に保存
    int port = 80;

    // InetAdress型？？DNSみたいな感じでdomainでipアドレスを返してもらえる
    InetAddress sAdd;
    // Stringをbufferって型としてsbuffを生成しておく。(加工しやすいString?)
    StringBuffer sBuff = new StringBuffer();

    try {
      // ipアドレスを取得、sAddに格納。
      sAdd = InetAddress.getByName(serverName);
      // new Socketはipアドレスと、port番号が必要なので、80番ポートでwww.example.comのipアドレスで接続？
      // 3way handshakeが行われている、自分のpc, サーバーでやり取りを一往復する。
      Socket soc = new Socket(sAdd, port);

      // outS: 出口（書き出す）, inS: 入口（読む） 
      BufferedWriter outS = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
      BufferedReader inS = new BufferedReader(new InputStreamReader(soc.getInputStream()));

      String[] msg = {
        // http methodとしてgetメソッドをして、/index.htmlエンドポイントを持つものを取得するものを
        "GET /index.html HTTP/1.0\r\n", 
        "\r\n"
      };

      // messageを一文字ずつ送信していく
      for(int i = 0; i < msg.length; i++){
        outS.write(msg[i]);
      }

      // outSにあるものを全部かきだす
      outS.flush();

      // tmpStringとして読むソケットの中身を一行にするために編集する
      String tmpString;
      while((tmpString = inS.readLine()) != null){
        sBuff.append(tmpString + "\n");
      }

      // sBuffをbufferから文字列に変形する
      System.err.println(sBuff.toString());
      
      // 全部閉じる
      outS.close();
      inS.close();
      soc.close();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}