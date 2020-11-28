public class Triangle implements Shape {
    double s1, s2, s3;

    public Triangle(double s1, double s2, double s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public double area() {
        // Heron's formula for the area of a triangle given its side lengths
        // https://en.wikipedia.org/wiki/Heron%27s_formula
        double x = perimeter() / 2;
        return Math.sqrt(x * (x - s1) * (x - s2) * (x - s3));
    }

    public double perimeter() {
        return s1 + s2 + s3;
    }

    public String getName() {
        return "Triangle";
    }
}