public class LC5_LongestPalindromicSubstring {
    // solution 2 dynamic programming
//    public String longestPalindrome(String s) {
//        if(s.equals("")) return s;
//        int max = 1;
//        int l = 0;
//        int r = 0;
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        for(int i=0;i<s.length();i++){
//            dp[i][i] = true;
//        }
//        for(int i=1;i<s.length();i++){
//            for(int j=0;j<s.length()-i;j++){
//                dp[j][j+i] = i==1?s.charAt(j)==s.charAt(j+i):dp[j+1][j+i-1]&&s.charAt(j)==s.charAt(j+i);
//                if(dp[j][j+i] && i+1>max){
//                    max = i+1;
//                    l = j;
//                    r = j+i;
//                }
//            }
//        }
//        return s.substring(l, r+1);
//    }
    // solution 1
    public String longestPalindrome(String s) {
        int max = 0;
        String res = null;
        for(int i=0;i<s.length();i++){
            int l = i;
            int r = i;
            while(l>=0 && s.charAt(l)==s.charAt(i)) l--;
            while(r<s.length() && s.charAt(r)==s.charAt(i)) r++;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(r-l-1>max) {
                max = r-l-1;
                res = s.substring(l+1, r);
            }
        }
        return res;
    }
}
