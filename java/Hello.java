import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Hello {
  public static void main(String[] args) throws IOException{
    Path path = Paths.get("sample.txt");
    try {
      String content = Files.readString(path);
      System.out.println(content);
    } catch (Exception e) {
      println("")

    }
  }
}