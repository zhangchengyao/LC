public class LC300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int[] dp = new int[nums.length+1];
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i-1;j++){
                if(nums[i-1]>nums[j]) dp[i] = Math.max(dp[i], dp[j+1]+1);
                else dp[i] = Math.max(dp[i], 1);
            }
        }
        int max = 0;
        for(int i=1;i<dp.length;i++){
            if(dp[i]>max) max = dp[i];
        }
        return max;
    }
}
