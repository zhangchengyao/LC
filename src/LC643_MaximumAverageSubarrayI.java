public class LC643_MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double runningSum = 0;
        for(int i = 0; i < k; i++) {
            runningSum += nums[i];
        }
        double maxSum = runningSum;
        for(int i = k; i < nums.length; i++) {
            runningSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum / k;
    }
}
