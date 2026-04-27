import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class simplewindowtext extends Application {
  private Button bt;
  private TextField tf;

  
  public static void main(String[] args) {
    launch(args);
  }
  public void start(Stage stage) throws Exception {
    bt = new Button("押せ");
    tf = new TextField("0");
    BorderPane bp = new BorderPane();
    bp.setCenter(bt);
    bp.setBottom(tf);
    Scene sc = new Scene(bp, 300, 200);
    stage.setScene(sc);
    stage.setTitle("カウンター");
    stage.show();
  }
}
