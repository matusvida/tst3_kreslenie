package Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Created by Matus on 02.03.2017.
 */
public class Circle extends Shape{
    private javafx.scene.shape.Circle circle;

    public Circle(double rozmer, double x, double y, Color color, int z_index) {
        super(rozmer, x, y, color, z_index);
    }

    @Override
    public void draw(Canvas canvas) {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(getColor());
        gc.fillOval(getX(), getY(), getRozmer(), getRozmer());

//        gc.s
        circle = new javafx.scene.shape.Circle(getX(), getY(), getRozmer(), getColor());
    }
}
