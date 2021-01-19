public class Main {
    static Parser parser = new Parser();

    public static void test(String expression) {
        int result = parser.evaluate(expression);
        System.out.printf("EXPRESSION: %s%nRESULT:  %d%n", expression, result);
    }
    public static void main(String[] args) {
        test("(((13 - 1) / 2) * (3 + 5))");

        /*
        >>> javac Parser.java Main.java; java Main
        >>> EXPRESSION: (((13 - 1) / 2) * (3 + 5))
        >>> RESULT:  48
        */
    }
}
