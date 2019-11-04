public class LC651_4KeysKeyboard {
    public int maxA(int N) {
        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            dp[i] = i;
            for(int j = i - 3; j >= 1; j--) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }

        return dp[N];
    }

//    public int maxA(int N) {
//        if(N < 7) return N;
//
//        int max = 0;
//        for(int i = N - 3; i > 1; i--) {
//            int cur = maxA(i) * (N - i - 1);
//            max = Math.max(max, cur);
//        }
//
//        return max;
//    }
}
