public class LC664_StrangePrinter {
    public int strangePrinter(String s) {
        if(s == null || s.length() == 0) return 0;

        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for(int len = 2; len <= s.length(); len++) {
            for(int i = 0; i <= s.length() - len; i++) {
                int end = i + len - 1;
                dp[i][end] = Integer.MAX_VALUE;
                for(int j = i; j < end; j++) {
                    int turns = dp[i][j] + dp[j + 1][end];
                    dp[i][end] = Math.min(dp[i][end], s.charAt(j) == s.charAt(end) ? turns - 1 : turns);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
