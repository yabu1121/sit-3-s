import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;

public class simplewindow extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  public void start(Stage stage) throws Exception {
      BorderPane ap = new BorderPane();
      Scene sc = new Scene(ap, 300, 200);
      stage.setScene(sc);
      stage.setTitle("カウンター");
      stage.show();
  }
}
