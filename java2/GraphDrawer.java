import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;

public class GraphDrawer extends Application {
  private static int n;
  private static int m;

  public static void main(String[] args) {
    n = Integer.parseInt(args[0]);
    m = Integer.parseInt(args[1]);
    launch(args);
  }

  public void start(Stage stage) throws Exception {
    Canvas cv = new Canvas(500, 500);
    GraphicsContext gc = cv.getGraphicsContext2D();
    gc.setLineWidth(1);
    gc.setStroke(Color.BLACK);

    Lissajous lis = new Lissajous(n, m);
    lis.draw(cv);

    BorderPane bp = new BorderPane();
    bp.setCenter(cv);
    Scene sc = new Scene(bp, 500, 500);
    stage.setScene(sc);
    stage.setTitle("リサージュ図形");
    stage.show();
  }
}
