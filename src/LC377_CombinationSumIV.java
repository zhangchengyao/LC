public class LC377_CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i-nums[j]>0) dp[i] += dp[i-nums[j]];
                else if(i==nums[j]) dp[i] += 1;
            }
        }
        return dp[target];
    }
}
