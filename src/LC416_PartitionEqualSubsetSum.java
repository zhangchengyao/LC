import java.util.HashMap;

public class LC416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int half = sum/2;
        if(half*2!=sum) return false;

        boolean[] dp = new boolean[half+1];
        dp[0] = true;
        for(int i=0;i<nums.length;i++){
            for(int j=dp.length-1;j>=nums[i];j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[half];
    }
//    public boolean canPartition(int[] nums) {
//        if(nums.length<2) return false;
//        int sum = 0;
//        for(int i=0;i<nums.length;i++){
//            sum += nums[i];
//        }
//        int half = sum/2;
//        if(half*2!=sum) return false;
//
//        boolean[][] dp = new boolean[nums.length][half+1];
//        for(int i=0;i<nums.length;i++) dp[i][0] = true;
//        dp[0][nums[0]] = true;
//        for(int i=1;i<nums.length;i++){
//            for(int j=1;j<=half;j++){
//                if(nums[i]>j) dp[i][j] = dp[i-1][j];
//                else dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
//            }
//        }
//        return dp[nums.length-1][half];
//    }
}
