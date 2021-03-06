import java.util.Arrays;

public class LC801_MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int[][] dp = new int[A.length][2];
        dp[0][1] = 1;

        for(int i = 1; i < A.length; i++) {
            dp[i][0] = Integer.MAX_VALUE / 2;
            dp[i][1] = Integer.MAX_VALUE / 2;

            if(A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
            if(A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }

        return Math.min(dp[A.length - 1][0], dp[A.length - 1][1]);
    }
}
