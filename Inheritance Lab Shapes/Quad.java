public abstract class Quad {
    double s1, s2, s3, s4;
    String name;

    Quad(double s1, double s2, double s3, double s4, String name) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.name = name;
    }

    public double perimeter() {
        return s1 + s2 + s3 + s4;
    }

    public String toString() {
        return "Quad";
    }

    public String getName() {
        return name;
    }
}