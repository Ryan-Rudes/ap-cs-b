public class Square extends Quad {
    public Square(double side) {
        super(side, side, side, side, "Square");
    }

    public double area() {
        return Math.pow(s1, 2);
    }
}