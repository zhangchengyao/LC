public class LC376_WiggleSubsequence {
    // Greedy algorithm with run time O(n)
//    public int wiggleMaxLength(int[] nums) {
//        if(nums.length<2) return nums.length;
//        int p = 1; // p denotes the longest wiggle sequence ending in ascending order
//        int q = 1; // q denotes the longest wiggle sequence ending in descending order
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]>nums[i-1]) p = q + 1;
//            else if(nums[i]<nums[i-1]) q = p + 1;
//        }
//        return Math.max(p, q);
//    }
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2) return nums.length;
        int[] dp = new int[nums.length];
        int[] diff = new int[nums.length];
        dp[0] = 1;
        diff[1] = nums[1] - nums[0];
        if(diff[1]==0) dp[1] = 1;
        else dp[1] = 2;
        for(int i=2;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]==nums[j]) dp[i] = Math.max(dp[i], 1);
                else if(dp[j]==1){
                    if(dp[i]<2){
                        dp[i] = 2;
                        diff[i] = nums[i]-nums[j];
                    }
                }
                else{
                    if((diff[j]>0 && nums[i]<nums[j]) || diff[j]<0 && nums[i]>nums[j]){
                        if(dp[j]+1>dp[i]){
                            dp[i] = dp[j]+1;
                            diff[i] = nums[i]-nums[j];
                        }
                    }
                    else dp[i] = Math.max(dp[i], 1);
                }
            }
        }
        int max = -1;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max) max = dp[i];
        }
        return max;
    }
}
