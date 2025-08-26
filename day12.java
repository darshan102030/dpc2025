import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String s) {
        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Traverse each character in the string
        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If it's a closing bracket, check stack
            else {
                // If stack is empty, no opening bracket available → invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop(); // Get last opened bracket

                // Check if closing matches opening
                if ( (ch == ')' && top != '(') ||
                     (ch == '}' && top != '{') ||
                     (ch == ']' && top != '[') ) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }

    // Test the code
    public static void main(String[] args) {
        String s1 = "[{()}]";
        String s2 = "([)]";
        String s3 = "((()))";
        String s4 = "({[})";

        System.out.println(s1 + " -> " + isValid(s1)); // true
        System.out.println(s2 + " -> " + isValid(s2)); // false
        System.out.println(s3 + " -> " + isValid(s3)); // true
        System.out.println(s4 + " -> " + isValid(s4)); // false
    }
}
