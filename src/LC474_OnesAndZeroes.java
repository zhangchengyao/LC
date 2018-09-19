public class LC474_OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=1;i<=strs.length;i++){
            String str = strs[i-1];
            int num0 = 0;
            int num1 = 0;
            for(int c=0;c<str.length();c++){
                if(str.charAt(c)=='0') num0++;
                else num1++;
            }
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    if(j-num0>=0 && k-num1>=0) dp[i][j][k] = Math.max(dp[i-1][j-num0][k-num1]+1, dp[i-1][j][k]);
                    else dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
