public class LC639_DecodeWaysII {
    public int numDecodings(String s) {
        int mod = 1000000007;

        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        for(int i = 1; i <= s.length(); i++) {
            char cur = s.charAt(i - 1);
            char pre = i > 1 ? s.charAt(i - 2) : ' ';
            if(cur == '*') {
                if(i == 1) {
                    dp[i] = 9;
                } else {
                    dp[i] = (dp[i - 1] * 9) % mod;
                    if(pre == '1') {
                        dp[i] = (dp[i] + dp[i - 2] * 9) % mod;
                    } else if(pre == '2') {
                        dp[i] = (dp[i] + dp[i - 2] * 6) % mod;
                    } else if(pre == '*') {
                        dp[i] = (dp[i] + dp[i - 2] * 15) % mod;
                    }
                }
            } else if(cur == '0') {
                if(i == 1) return 0;

                if(pre == '*') {
                    dp[i] = (dp[i - 2] * 2) % mod;
                } else if(pre > '2' || pre == '0') {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else if(cur <= '6') {
                dp[i] = dp[i - 1];
                if(pre == '*') {
                    dp[i] = (dp[i] + dp[i -2] * 2) % mod;
                } else if(pre == '1' || pre == '2') {
                    dp[i] = (dp[i] + dp[i - 2]) % mod;
                }
            } else {
                dp[i] = dp[i - 1];
                if(pre == '*' || pre == '1') {
                    dp[i] = (dp[i] + dp[i - 2]) % mod;
                }
            }
        }

        return (int)dp[s.length()];
    }
}
