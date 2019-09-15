public class LC696_CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int cur = 1;
        int pre = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        res += Math.min(pre, cur);

        return res;
    }
}
