public class LC712_MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        int asciiSum1 = 0;
        int asciiSum2 = 0;
        for(char c: s1.toCharArray()) {
            asciiSum1 += c;
        }
        for(char c: s2.toCharArray()) {
            asciiSum2 += c;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + (int)s1.charAt(i - 1));
                }
            }
        }

        return asciiSum1 - dp[n][m] + asciiSum2 - dp[n][m];
    }
}
