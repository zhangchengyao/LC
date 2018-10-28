public class LC312_BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] numsS = new int[nums.length+2];
        for(int i=0;i<nums.length;i++) numsS[i+1] = nums[i];
        numsS[0] = 1; numsS[numsS.length-1] = 1;
        int[][] dp = new int[numsS.length][numsS.length];
        for(int i=1;i<=nums.length;i++) dp[i][i] = numsS[i];
        for(int len=1;len<=nums.length;len++){
            for(int left=1;left<=nums.length-len+1;left++){
                int right = left+len-1;
                for(int k=left;k<=right;k++){
                    dp[left][right] = Math.max(dp[left][right], dp[left][k-1]+numsS[left-1]*numsS[k]*numsS[right+1]+dp[k+1][right]);
                }
            }
        }
        return dp[1][nums.length];
    }
}
