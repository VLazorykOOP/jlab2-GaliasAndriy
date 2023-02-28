import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Stack;

public class Expression {
    public static int calculate (String expr) {
        Stack<Character> opStack = new Stack<Character>();
        Stack<Integer> numStack = new Stack<Integer>();

        if (expr.length() == 0) {
            return 0;
        }

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == ' ') {
                continue;
            }
           
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(expr.charAt(i));
                    i++;
                }
                i--;

                numStack.push(num);
            }
            
            else if (c == '+' || c == '-' || c == '*') {
                while (!opStack.empty() && precedence(c, opStack.peek())) { // choose the first elem from the stack without removing it
                    int b = numStack.pop();
                    int a = numStack.pop();
                    char oper = opStack.pop();
                    int result = appendOp(a, b, oper);
                    numStack.push(result);    
                }

                opStack.push(c);
            }
        }
        while (!opStack.empty()) {
            int b = numStack.pop();
            int a = numStack.pop();
            char oper = opStack.pop();
            int result = appendOp(a, b, oper);
            numStack.push(result);
        }
        
        return numStack.pop();
    }

    public static boolean precedence(char oper1, char oper2) {
        if ((oper1 == '*' || oper1 == '/') && (oper2 == '+' || oper2 == '-')) {
            return false;
        }
        return true;
    }

    public static int appendOp(int a, int b, char oper) {
        switch (oper) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Input an expression: ");
        String expression = scanner.nextLine();
        int result = calculate(expression);
        System.out.println(expression + " = " + result);
    }
}