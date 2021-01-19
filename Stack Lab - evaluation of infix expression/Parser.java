import java.util.Stack;

public class Parser {
    // Instantiate two stacks for operators and operands
    Stack<Character> operators = new Stack<Character>();
    Stack<Integer> operands = new Stack<Integer>();

    // A StringBuilder instance which will be
    // used to parse operands, for they can
    // potentially be more than 1 digit in length
    StringBuilder digits;
    
    // Variables to store operands when
    // performing mathematical operations,
    // as well as the result of the calculation
    int operandA;
    int operandB;
    int result;

    char operator;
    char token;
    
    /**
     * Returns a boolean indicating whether the token is a mathematical operator
     * @param  t  a token
     * @return    whether the token is one of add., sub., multi., or div.
     */
    private boolean isOperator(char t) {
        return t == '+' || t == '-' || t == '*' || t == '/';
    }

    /**
     * Returns a boolean indicating whether the token is a mathematical operand
     * @param  t  a token
     * @return    whether the token is a numerical digit, ie. 0-9
     */
    private boolean isOperand(char t) {
        return t >= '0' && t <= '9';
    }

    /**
     * Performs the provided operation upon the given inputs
     * @param T         the left-hand side operator
     * @param U         the right-hand side operator
     * @param operator  the operation to perform
     * @return          the result of performing the operator on T and U
     */
    private static int operate(int T, int U, char operator) {
        switch (operator) {
            case '+':
                return T + U;
            case '-':
                return T - U;
            case '*':
                return T * U;
            case '/':
                // Onlt divisible values are going to be included
                // in the given expressions, ie. test cases
                return T / U;
            default:
                // Never will be reached
                return -1;
        }
    }

    public int evaluate(String expression) {
        // Clear the stacks
        operators.removeAllElements();
        operands.removeAllElements();

        // Conver the expression to an array of character tokens
        char[] expressionChar = expression.toCharArray();
        
        for (int i = 0; i < expressionChar.length; i++) {
            token = expressionChar[i];

            if (token == ')') {
                operandB = operands.pop();
                operandA = operands.pop();
                operator = operators.pop();
                result = operate(operandA, operandB, operator);
                operands.add(result);
            } else if (isOperand(token)) {
                // Parse digits until something else is reached
                digits = new StringBuilder();

                do {
                    digits.append(token);
                    i++;
                    token = expressionChar[i];
                } while (isOperand(expressionChar[i]));
                i--;
                operands.add(Integer.valueOf(digits.toString()));
            } else if (isOperator(token)) {
                operators.add(token);
            } // Skip whitespace and left (open) parentheses
        }

        return operands.pop();
    }
}
