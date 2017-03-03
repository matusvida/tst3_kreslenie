package Shapes;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Created by Matus on 02.03.2017.
 */
public class Circle extends Shape{
    private javafx.scene.shape.Circle circle;
    private double x;
    private double y;

    public Circle(double rozmer, double x, double y, Color color, int z_index) {
        super(rozmer, x, y, color, z_index);
    }

    @Override
    public void draw() {
        circle = new javafx.scene.shape.Circle(x, y, getRozmer(), getColor());
    }
}
