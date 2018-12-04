import java.util.Stack;

public class LC20_ValidParentheses {
    public boolean isValid(String s) {
        if(s.equals("")) return true;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='[' || c=='{') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                char open = stack.pop();
                if(c==')'){
                    if(open!='(') return false;
                }else if(c==']'){
                    if(open!='[') return false;
                }else{
                    if(open!='{') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
