import java.util.*;

class PostfixEvaluation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();  // Second operand
                int a = stack.pop();  // First operand
                int result = applyOperation(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token)); // Push number to stack
            }
        }
        
        return stack.pop(); // Final result
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperation(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division truncates towards zero in Java
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens)); // Output: 9
    }
}
