public class LC718_MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = A[0]==B[i]?1:0;
            dp[i][0] = B[0]==A[i]?1:0;
            if(dp[0][i]>0 || dp[i][0]>0) res = 1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp.length;j++){
                dp[i][j] = A[i]==B[j]?dp[i-1][j-1]+1:0;
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
