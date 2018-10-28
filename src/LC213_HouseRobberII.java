public class LC213_HouseRobberII {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    private int rob(int[] nums, int left, int right){
        int[] dp = new int[right-left+1];
        for(int i=0;i<dp.length;i++){
            if(i==0){
                dp[i] = nums[left+i];
                continue;
            }
            if(i==1){
                dp[i] = Math.max(dp[i-1], nums[left+i]);
                continue;
            }
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[left+i]);
        }
        return dp[dp.length-1];
    }
}
