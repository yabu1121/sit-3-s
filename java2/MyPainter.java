import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class MyPainter extends Application {
  private Canvas cv;
  private boolean started = false;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) throws Exception {
    cv = new Canvas(400, 300);
    GraphicsContext gc = cv.getGraphicsContext2D();
    gc.setLineWidth(3);
    gc.setStroke(Color.BLACK);
    gc.beginPath();
    cv.addEventHandler(MouseEvent.MOUSE_PRESSED, new MousePressedHandler());

    BorderPane bp = new BorderPane();
    bp.setCenter(cv);
    Scene sc = new Scene(bp, 400, 300);
    stage.setScene(sc);
    stage.setTitle("ペインター");
    stage.show();
  }

  class MousePressedHandler implements EventHandler<MouseEvent> {
    public void handle(MouseEvent e) {
      GraphicsContext gc = cv.getGraphicsContext2D();
      if (started == false) {
        if (e.isPrimaryButtonDown() == true) {
          gc.moveTo(e.getX(), e.getY());
          started = true;
        }
      } else {
        gc.lineTo(e.getX(), e.getY());
        if (e.isSecondaryButtonDown() == true) {
          started = false;
        }
      }
      gc.stroke();
    }
  }
}
