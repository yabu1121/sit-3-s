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
    String serverName = "www.example.com";
    int port = 80;

    InetAddress sAdd;
    StringBuffer sBuff = new StringBuffer();

    try {
      sAdd = InetAddress.getByName(serverName);
      Socket soc = new Socket(sAdd, port);
      BufferedWriter outS = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
      BufferedReader inS = new BufferedReader(new InputStreamReader(soc.getInputStream()));

      String[] msg = {
        "GET /index.html HTTP/1.0\r\n", 
        "\r\n"
      };

      for(int i = 0; i < msg.length; i++){
        outS.write(msg[i]);
      }
      outS.flush();

      String tmpString;
      while((tmpString = inS.readLine()) != null){
        sBuff.append(tmpString + "\n");
      }

      System.err.println(sBuff.toString());
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