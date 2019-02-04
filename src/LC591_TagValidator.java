import java.util.Stack;

public class LC591_TagValidator {
    public boolean isValid(String code) {
        if(code.charAt(0) != '<') return false;

        int i = 0;
        Stack<String> stack = new Stack<>();

        while(i < code.length()){
            if(code.charAt(i) == '<'){
                int j = i + 1;

                if(code.charAt(j) == '!'){
                    if(i == 0 || j + 8 > code.length() || !code.substring(j+1, j+8).equals("[CDATA[")) return false;

                    j += 8;

                    while(j + 3 <= code.length() && !code.substring(j, j+3).equals("]]>")) j++;
                    if(j + 3 > code.length()) return false;

                    i = j + 3;
                } else if(code.charAt(j) == '/'){
                    while(j < code.length() && code.charAt(j) != '>') j++;
                    if(j == code.length()) return false;

                    String tagName = code.substring(i+2, j);
                    if(!isValidTagName(tagName) || stack.isEmpty()) return false;

                    String start = stack.pop();
                    if(!start.equals(tagName)) return false;

                    i = j + 1;
                    if(stack.isEmpty() && i < code.length()) return false;
                } else {
                    while(j < code.length() && code.charAt(j) != '>') j++;
                    if(j == code.length()) return false;

                    String tagName = code.substring(i+1, j);

                    if(!isValidTagName(tagName)) return false;
                    if(stack.isEmpty() && i != 0) return false;

                    stack.push(tagName);
                    i = j + 1;
                }
            } else {
                if(stack.isEmpty()) return false;
                i++;
            }
        }
        return stack.isEmpty();
    }

    private boolean isValidTagName(String name){
        if(name.length() >= 1 && name.length() <= 9){
            for(char c: name.toCharArray()){
                if(!(c >= 'A' && c <= 'Z')) return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
