import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TCP_Server {
  public static void main(String[] args) {
    int port = 10007;
    try {
      ServerSocket srvSock = new ServerSocket(port);
      boolean flg = true;
      while (flg == true) {
        Socket skt = srvSock.accept();
        
        InputStreamReader iSR = new InputStreamReader(skt.getInputStream());
        BufferedReader inS = new BufferedReader(iSR);
  
        OutputStreamWriter oSW = new OutputStreamWriter(skt.getOutputStream());
        PrintWriter outS = new PrintWriter(oSW,true);
  
        String inMsg = inS.readLine();
  
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("MM/dd HH:mm:ss");
        String outMsg = nowDateTime.format(java8Format ) + "(" + inMsg + ")";
  
        System.out.println(outMsg);
        outS.println(outMsg);
  
        inS.close();
        outS.close();
        skt.close();
      }
      srvSock.close();
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}
