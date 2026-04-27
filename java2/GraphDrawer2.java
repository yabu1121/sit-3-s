import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class GraphDrawer2 extends Application {
  private Canvas cv;
  private TextField tfN;
  private TextField tfM;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) throws Exception {
    cv = new Canvas(500, 500);
    GraphicsContext gc = cv.getGraphicsContext2D();
    gc.setLineWidth(1);
    gc.setStroke(Color.BLACK);

    // textfiled : input
    // 引数 : 初期値
    tfN = new TextField("10");
    tfM = new TextField("9");
    Button bt = new Button("描画");
    bt.setOnAction(new DrawEventHandler());

    // vbox 垂直にレイアウトする
    VBox vb = new VBox(5);
    // n, m, btを縦に並べる
    vb.getChildren().addAll(tfN, tfM, bt);

    BorderPane bp = new BorderPane();
    bp.setTop(vb);
    bp.setCenter(cv);
    Scene sc = new Scene(bp, 500, 600);
    stage.setScene(sc);
    stage.setTitle("リサージュ図形");
    stage.show();
  }

  class DrawEventHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent e) {
      int n = Integer.parseInt(tfN.getText());
      int m = Integer.parseInt(tfM.getText());
      Lissajous lis = new Lissajous(n, m);
      GraphicsContext gc = cv.getGraphicsContext2D();
      gc.clearRect(0, 0, cv.getWidth(), cv.getHeight());
      lis.draw(cv);
    }
  }
}
