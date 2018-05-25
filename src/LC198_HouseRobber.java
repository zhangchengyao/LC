public class LC198_HouseRobber {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                dp[i] = nums[i];
                continue;
            }
            if(i==1){
                dp[i] = Math.max(dp[i-1], nums[i]);
                continue;
            }
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
