public class LC730_CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String S) {
        int[][] dp = new int[S.length()][S.length()];
        for(int i=0;i<S.length();i++) dp[i][i] = 1;
        for(int i=1;i<S.length();i++){
            for(int j=0;j<S.length()-i;j++){
                if(S.charAt(j)==S.charAt(j+i)){
                    int index1 = S.substring(j+1, j+i).indexOf(S.charAt(j));
                    int index2 = S.substring(j+1, j+i).lastIndexOf(S.charAt(j));
                    if(index1==-1){
                        dp[j][j+i] = dp[j+1][j+i-1]*2 + 2;
                    }else if(index1 == index2){
                        dp[j][j+i] = dp[j+1][j+i-1]*2 + 1;
                    }else if(index1<index2){
                        dp[j][j+i] = dp[j+1][j+i-1]*2 - dp[j+2+index1][j+index2];
                    }
                }else{
                    dp[j][j+i] = dp[j][j+i-1] + dp[j+1][j+i] - dp[j+1][j+i-1];
                }
                while(dp[j][j+i]<0) dp[j][j+i] += 1000000007;
                dp[j][j+i] %= 1000000007;
            }
        }
        return dp[0][S.length()-1];
    }
}
