import java.util.Stack;

public class LC150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int a, b;
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                a = s.pop();
                b = s.pop();
                s.push(b+a);
            }else if(tokens[i].equals("-")){
                a = s.pop();
                b = s.pop();
                s.push(b-a);
            }else if(tokens[i].equals("*")){
                a = s.pop();
                b = s.pop();
                s.push(b*a);
            }else if(tokens[i].equals("/")){
                a = s.pop();
                b = s.pop();
                s.push(b/a);
            }else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}
