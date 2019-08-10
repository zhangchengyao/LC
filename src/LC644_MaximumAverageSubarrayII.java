public class LC644_MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        double left = Integer.MAX_VALUE;
        double right = Integer.MIN_VALUE;
        for(int n: nums) {
            left = Math.min(left, n);
            right = Math.max(right, n);
        }

        while(right - left >= 1e-5) {
            double preSum = 0;
            double minSum = 0;
            double sum = 0;
            double mid = left + (right - left) / 2;
            boolean check = false;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i] - mid;
                if(i >= k) {
                    preSum += nums[i - k] - mid;
                    minSum = Math.min(minSum, preSum);
                }
                if(i >= k - 1 && sum - minSum > 0) {
                    check = true;
                    break;
                }
            }
            if(check) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // naive solution
//    public double findMaxAverage(int[] nums, int k) {
//        int[] sums = new int[nums.length + 1];
//        for(int i = 0; i < nums.length; i++) {
//            sums[i + 1] = sums[i] + nums[i];
//        }
//
//        double res = -Double.MAX_VALUE;
//        for(int len = k; len <= nums.length; len++) {
//            int maxSum = Integer.MIN_VALUE;
//            for(int j = 0; j < nums.length - len + 1; j++) {
//                maxSum = Math.max(maxSum, sums[j + len] - sums[j]);
//            }
//            res = Math.max(res, maxSum * 1.0 / len);
//        }
//
//        return res;
//    }
}
