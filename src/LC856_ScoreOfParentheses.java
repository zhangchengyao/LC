public class LC856_ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        if(S == null || S.length() == 0) return 0;

        int r = getRightIndex(S, 0);
        if(r == 1) return 1 + scoreOfParentheses(S.substring(2));

        return 2 * scoreOfParentheses(S.substring(1, r)) + scoreOfParentheses(S.substring(r + 1));
    }

    private int getRightIndex(String S, int left) {
        int cnt = 1;
        for(int i = left + 1; i < S.length(); i++) {
            if(S.charAt(i) == '(') cnt++;
            else if(S.charAt(i) == ')') cnt--;

            if(cnt == 0) return i;
        }

        return -1;
    }
}
