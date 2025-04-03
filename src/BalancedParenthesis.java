import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {

        String validParenthisis = "([{((()))}({{[]}})])";

        System.out.println(isvalidParenthisis(validParenthisis));


    }

    public static boolean isvalidParenthisis(String validParenthisis) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <= validParenthisis.length() - 1; i++) {

            if (validParenthisis.charAt(i) == '(' || validParenthisis.charAt(i) == '{' || validParenthisis.charAt(i) == '[') {
                stack.push(validParenthisis.charAt(i));
            } else {
                char ch = stack.peek();
                if (!stack.empty() && (validParenthisis.charAt(i) == ')' && ch == '(' || validParenthisis.charAt(i) == '}' && ch == '{' || validParenthisis.charAt(i) == ']' && ch == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
    return stack.isEmpty();
    }

}
