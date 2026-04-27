import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class MyCounter extends Application {
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
    bt.setOnAction(new CountUpEventHandler());
    Scene sc = new Scene(bp, 300, 200);
    stage.setScene(sc);
    stage.setTitle("カウンター");
    stage.show();
  }

  class CountUpEventHandler implements EventHandler<ActionEvent> {
    public void handle (ActionEvent e){
      String tmp = tf.getText();
      int cnt = Integer.parseInt(tmp);
      tf.setText(String.valueOf(cnt + 1));
    }
  }
}


// cd "c:/univ 3-early/coding/java2" && java --module-path "C:\Users\nhaya\Downloads\javafx-sdk-26.0.1\lib" --add-modules javafx.controls --enable-native-access=javafx.graphics MyCounter 2>&1