import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP_Client {
  public static void main(String[] args) {
    int port = 10007;
    try {
      Socket skt = new Socket("172.31.4.147", port);
      OutputStreamWriter oSW = new OutputStreamWriter(skt.getOutputStream());
      PrintWriter outS = new PrintWriter(oSW, true);

      InputStreamReader isr = new InputStreamReader(skt.getInputStream());
      BufferedReader inS = new BufferedReader(isr);

      if(args.length == 0){
        outS.println("");
      }else{
        outS.println(args[0]);
      }

      String tmpString = "";
      while ((tmpString = inS.readLine()) != null) {
        System.err.println(tmpString);
      }

      inS.close();
      outS.close();
      skt.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
