import java.util.Arrays;

public class LC300_LongestIncreasingSubsequence {
    // binary search O(nlogn)
//    public int lengthOfLIS(int[] nums) {
//        if(nums.length<=1) return nums.length;
//        int[] tail = new int[nums.length];
//        Arrays.fill(tail, Integer.MAX_VALUE);
//        int len = 1;
//        tail[0] = nums[0];
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]>tail[len-1]){
//                tail[len++] = nums[i];
//            }
//            else{
//                int idx = Arrays.binarySearch(tail, nums[i]);
//                if(idx<0) idx = -idx-1;
//                tail[idx] = nums[i];
//            }
//        }
//        return len;
//    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
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
