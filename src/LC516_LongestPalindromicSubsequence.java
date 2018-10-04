public class LC516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<dp.length;i++) dp[i][i] = 1;
        for(int i=1;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                if(i==1) dp[j][j+i] = s.charAt(j)==s.charAt(j+i)?2:1;
                else dp[j][j+i] = s.charAt(j)==s.charAt(j+i)?dp[j+1][j+i-1]+2:Math.max(dp[j][j+i-1], dp[j+1][j+i]);
            }
        }
        return dp[0][s.length()-1];
    }
}
