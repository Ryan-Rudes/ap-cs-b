public class Trapezoid extends Quad {
    public class NotIsoscelesException extends Exception {
        public NotIsoscelesException(String message) {
            super(message);
        }
    }

    double height;

    /**
     * Isosceles trapezoid class constructor
     * 
     * An isosceles trapezoid is a trapezoid with two parallel
     * opposite sides (given) and two slanted sides of equal
     * length (special case)
     *  
     * @param base1 The length of a base of the trapezoid
     * @param base2 The length of the opposing base
     * @param slant The length of the slanted side
     */
    public Trapezoid(double base1, double base2, double slant) throws NotIsoscelesException {
        super(base1, slant, base2, slant, "Trapezoid");

        double maxBase = Math.max(base1, base2);
        double minBase = Math.min(base1, base2);

        if (minBase <= maxBase - 2 * slant || minBase >= maxBase)
            throw new NotIsoscelesException("The specified parameters do not conform to an isosceles trapezoid.");

        this.height = Math.sqrt(Math.pow(slant, 2) - Math.pow(base2 - base1, 2) / 4);
    }

    public double area() {
        return (s1 + s3) * height / 2;
    }
}