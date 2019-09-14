public class LC678_ValidParenthesisString {
    public boolean checkValidString(String s) {
        int leftParen = 0;
        for(char c: s.toCharArray()) {
            if(c == '(' || c == '*') {
                leftParen++;
            } else {
                leftParen--;
            }

            if(leftParen < 0) return false;
        }

        int rightParen = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == ')' || c == '*') {
                rightParen++;
            } else {
                rightParen--;
            }

            if(rightParen < 0) return false;
        }

        return true;
    }
}
