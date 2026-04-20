import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileContent {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("使用法: java coding.java.CreateFileContent [ファイル名] [内容]");
      return;
    }

    Path path = Paths.get(args[0]);
    String content = args[1];
    try {
      Files.writeString(path, content);
    } catch (IOException e) {
      System.err.println("失敗しました。");
      e.printStackTrace();
    }
  }
}
