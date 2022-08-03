import java.util.*;

public class ValidParentheses {
    public static boolean isValidParentheses(String s) {
        Map<Character, Character> openClosed = new HashMap<Character, Character>();

        openClosed.put('(', ')');
        openClosed.put('[', ']');
        openClosed.put('{', '}');

        Stack<Character> openBrackets = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                openBrackets.push(s.charAt(i));
            }else {
                if(openBrackets.isEmpty()){
                    return false;
                }
                if (s.charAt(i) != openClosed.get(openBrackets.peek() ) ) {
                    return false;
                }else{
                    openBrackets.pop();
                }
            }
        }

        return openBrackets.isEmpty();
    }



    public static void main(String[] args) {

        // Prints "Hello, World" to the terminal window.

        System.out.println(isValidParentheses("()") == true);

        System.out.println(isValidParentheses("()[]{}") == true);

        System.out.println(isValidParentheses("({[]})") == true);

        System.out.println(isValidParentheses("]") == false);

        System.out.println(isValidParentheses("(") == false);

        System.out.println(isValidParentheses("(]") == false);

        System.out.println(isValidParentheses("([)]") == false);

    }



}