import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Hello {
    public static void main(String[] args) {
        Path path = Paths.get("sample.txt");
        try {
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("エラー：ファイルを読み込めませんでした。");
            System.err.println("ファイルが存在するか確認してください: " + path.toAbsolutePath());
        }
    }
}