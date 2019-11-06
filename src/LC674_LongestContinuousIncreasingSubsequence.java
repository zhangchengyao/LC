public class LC674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 1;
        int cur = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        max = Math.max(max, cur);
        return max;
    }
}
