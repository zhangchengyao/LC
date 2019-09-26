public class LC808_SoupServings {
    private int[][] operations = {{4, 0}, {3, 1}, {2, 2}, {1, 3}};

    private double[][] dp;

    public double soupServings(int N) {
        N = (N + 24) / 25;
        if(N >= 480) return 1;

        dp = new double[N + 1][N + 1];

        return serve(N, N);
    }

    private double serve(int A, int B) {
        if(A <= 0 && B <= 0) return 0.5;
        if(A <= 0) return 1;
        if(B <= 0) return 0;

        if(dp[A][B] != 0) return dp[A][B];

        for(int[] ope: operations) {
            dp[A][B] += 0.25 * serve(A - ope[0], B - ope[1]);
        }

        return dp[A][B];
    }
}
