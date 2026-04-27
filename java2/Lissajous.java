import javafx.scene.canvas.*;

public class Lissajous {
  int n;
  int m;

  public Lissajous(int n, int m) {
    this.n = n;
    this.m = m;
  }

  public void draw(Canvas cv) {
    GraphicsContext gc = cv.getGraphicsContext2D();
    double a = cv.getWidth() / 2;
    double b = cv.getHeight() / 2;
    
    gc.beginPath();

    gc.moveTo(a + 200 * Math.cos(0), b + 200 * Math.sin(0));
    
    for (double t = 0.0; t <= 2 * Math.PI; t += 0.001) {
      double x = a + 200 * Math.cos(n * t);
      double y = b + 200 * Math.sin(m * t);
      gc.lineTo(x, y);
    }
    
    gc.stroke();
  }
}
