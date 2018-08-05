import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketChecker {

    public String input;

    public BracketChecker(String input){
        this.input = input;
    }

    public boolean areBracketsMatchedAndNestedCorrectly(){

        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

}
