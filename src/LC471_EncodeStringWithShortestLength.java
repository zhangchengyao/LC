public class LC471_EncodeStringWithShortestLength {
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = "";
            }
        }

        for(int len = 1; len <= n; len++) {
            for(int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = s.substring(i, i + len);
                String pattern = s.substring(i, i + len);
                String replace;
                int pos = (pattern + pattern).indexOf(pattern, 1);
                if(pos < pattern.length()) {
                    replace = (pattern.length() / pos) + "[" + dp[i][i + pos - 1] + "]";
                    if(replace.length() < dp[i][j].length()) {
                        dp[i][j] = replace;
                        continue;
                    }
                }
                for(int k = i; k < j; k++) {
                    String left = dp[i][k];
                    String right = dp[k + 1][j];
                    if(left.length() + right.length() < dp[i][j].length()) {
                        dp[i][j] = left + right;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
