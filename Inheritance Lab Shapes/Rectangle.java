public class Rectangle extends Quad {
    public Rectangle(double width, double height) {
        super(width, height, width, height, "Rectangle");
    }

    public double area() {
        return s1 * s2;
    }
}