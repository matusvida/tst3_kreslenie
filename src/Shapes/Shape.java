package Shapes;

/**
 * Created by Matus on 02.03.2017.
 */
public abstract class Shape {
    private double rozmer;
    private double x;
    private double y;
    private String color;
    private int z_index;

    public Shape(double rozmer, double x, double y, String color, int z_index){
        this.rozmer = rozmer;
        this.x = x;
        this.y = y;
        this.color = color;
        this.z_index = z_index;
    }

    public abstract void draw();

    public double getRozmer() {
        return rozmer;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public int getZ_index() {
        return z_index;
    }
}
