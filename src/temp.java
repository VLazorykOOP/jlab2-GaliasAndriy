import java.util.Stack;

public class Expression {
    public static int evaluate(String expression) {
        // Create two stacks - one for operands and one for operators
        Stack<Integer> operandStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();

        // Loop through the expression one character at a time
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the current character is a whitespace, skip it
            if (c == ' ') {
                continue;
            }

            // If the current character is a digit, push it onto the operand stack
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                i--;

                operandStack.push(num);
            }

            // If the current character is an operator, push it onto the operator stack
            else if (c == '+' || c == '-' || c == '*') {
                while (!operatorStack.empty() && hasPrecedence(c, operatorStack.peek())) {
                    int b = operandStack.pop();
                    int a = operandStack.pop();
                    char op = operatorStack.pop();
                    int result = applyOperation(a, b, op);
                    operandStack.push(result);
                }

                operatorStack.push(c);
            }
        }

        // Evaluate the remaining operators and operands
        while (!operatorStack.empty()) {
            int b = operandStack.pop();
            int a = operandStack.pop();
            char op = operatorStack.pop();
            int result = applyOperation(a, b, op);
            operandStack.push(result);
        }

        // The final result is the only element left on the operand stack
        return operandStack.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' ||  op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static int applyOperation(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expression = "3 + 4 * 2 - 1";
        int result = evaluate(expression);
        System.out.println(expression + " = " + result);
    }
}