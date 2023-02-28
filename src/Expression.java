import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Stack;

public class Expression {
    Stack<Character> opStack = new Stack<Character>();
    Stack<Integer> numStack = new Stack<Integer>();

    public int calculate (String expr) {
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
                    num = num * 10 + Character.getNumericValue(expr.charAt(i)); // 44 = 4 * 10 + 4
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

    // compare the precedence of the current operator oper1 with the top operator oper 
    public static boolean precedence(char oper1, char oper2) {
        if (oper1 == '*'  && (oper2 == '+' || oper2 == '-')) {
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
        Expression exp = new Expression();
        int result = exp.calculate(expression);
        System.out.println(expression + " = " + result);
    }
}