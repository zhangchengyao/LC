public class LC32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<2) return 0;
        int[] longestSub = new int[s.length()];
        longestSub[1] = s.charAt(0)=='('&&s.charAt(1)==')'?2:0;
        int res = longestSub[1];
        for(int i=2;i<longestSub.length;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='(') longestSub[i] = longestSub[i-2]+2;
                else{
                    int idx = i-longestSub[i-1]-1;
                    if(idx>=0 && s.charAt(idx)=='(') longestSub[i] = longestSub[i-1]+2+(idx>0?longestSub[idx-1]:0);
                }
            }
            if(longestSub[i]>res) res = longestSub[i];
        }
        return res;
    }
}
