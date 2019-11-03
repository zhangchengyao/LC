public class LC730_CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String S) {
        int mod = 1_000_000_007;
        int[][] dp = new int[S.length()][S.length()];
        for(int i = 0; i < S.length(); i++) dp[i][i] = 1;
        for(int i = 1; i < S.length(); i++){
            for(int j = 0; j < S.length() - i; j++) {
                int end = j + i;
                if(S.charAt(j) == S.charAt(end)) {
                    int index1 = S.substring(j + 1, end).indexOf(S.charAt(j));
                    int index2 = S.substring(j + 1, end).lastIndexOf(S.charAt(j));
                    if(index1 == -1) {
                        dp[j][end] = dp[j + 1][end - 1] * 2 + 2;
                    } else if(index1 == index2) {
                        dp[j][end] = dp[j + 1][end - 1] * 2 + 1;
                    } else if(index1 < index2) {
                        dp[j][end] = dp[j + 1][end - 1] * 2 - dp[j + 2 + index1][j + index2];
                    }
                } else {
                    dp[j][end] = dp[j][end - 1] + dp[j + 1][end] - dp[j + 1][end - 1];
                }
                while(dp[j][end] < 0) dp[j][end] += mod;
                dp[j][end] %= mod;
            }
        }
        return dp[0][S.length() - 1];
    }
}
