public class Main {
    public static void main(String[] args) throws Trapezoid.NotIsoscelesException {
        // Square
        Square square = new Square(3);
        System.out.println(String.format("area(): %f, perimeter(): %f, getName(): %s, toString(): %s", square.area(), square.perimeter(), square.getName(), square.toString()));
        // Rectangle
        Rectangle rect = new Rectangle(4, 8);
        System.out.println(String.format("area(): %f, perimeter(): %f, getName(): %s, toString(): %s", rect.area(), rect.perimeter(), rect.getName(), rect.toString()));
        // Trapezoid
        Trapezoid trap = new Trapezoid(3, 7, 5);
        System.out.println(String.format("area(): %f, perimeter(): %f, getName(): %s, toString(): %s", trap.area(), trap.perimeter(), trap.getName(), trap.toString()));
        // Parallelogram
        Parallelogram p = new Parallelogram(21, 32, 87);
        System.out.println(String.format("area(): %f, perimeter(): %f, getName(): %s, toString(): %s", p.area(), p.perimeter(), p.getName(), p.toString()));
        // Triangle
        Triangle tri = new Triangle(3, 4, 5);
        System.out.println(String.format("area(): %f, perimeter(): %f, getName(): %s", tri.area(), tri.perimeter(), tri.getName()));
        // Circle
        Circle circ = new Circle(5);
        System.out.println(String.format("area(): %f, perimeter(): %f, getName(): %s", circ.area(), circ.perimeter(), circ.getName()));

        /*
        area(): 9.000000, perimeter(): 12.000000, getName(): Square, toString(): Quad
        area(): 32.000000, perimeter(): 24.000000, getName(): Rectangle, toString(): Quad
        area(): 22.912878, perimeter(): 20.000000, getName(): Trapezoid, toString(): Quad
        area(): 335.539524, perimeter(): 106.000000, getName(): Parallelogram, toString(): Quad
        area(): 6.000000, perimeter(): 12.000000, getName(): Triangle
        area(): 78.539816, perimeter(): 31.415927, getName(): Circle
        */
    }
}