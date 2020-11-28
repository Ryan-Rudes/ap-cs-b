public class Parallelogram extends Quad {
    double a, b, theta;

    /**
     * @param a a side of the parallelogram
     * @param b the other side of the parallelogram
     * @param theta the angle between sides (degrees)
     */
    public Parallelogram(double a, double b, double theta) {
        super(a, b, a, b, "Parallelogram");
        this.a = a;
        this.b = b;
        this.theta = Math.toRadians(theta);
    }

    public double area() {
        return a * b * Math.sin(theta) / 2;
    }
}