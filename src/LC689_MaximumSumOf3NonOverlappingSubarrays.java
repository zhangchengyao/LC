public class LC689_MaximumSumOf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for(int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        // left[i] denotes the starting index of max subarray upto i
        int[] left = new int[n];
        left[k - 1] = 0;
        for(int i = k; i < n - 2 * k; i++) {
            int cur = sums[i] - sums[i - k];
            int prevMax = sums[left[i - 1] + k - 1] - (left[i - 1] == 0 ? 0 : sums[left[i - 1] - 1]);
            if(cur > prevMax) {
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }

        // right[i] denotes the starting index of max subarray upto i (from right to left)
        int[] right = new int[n];
        right[n - k] = n - k;
        for(int i = n - k - 1; i > 2 * k - 1; i--) {
            int cur = sums[i + k - 1] - sums[i - 1];
            int prevMax = sums[right[i + 1] + k - 1] - sums[right[i + 1] - 1];
            if(cur >= prevMax) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }

        int maxSum = -1;
        int[] res = new int[3];
        for(int mid = k; mid <= n - 2 * k; mid++) {
            int l = left[mid - 1];
            int r = right[mid + k];
            int curMax = sums[l + k - 1] - (l == 0 ? 0 : sums[l - 1]) + sums[mid + k - 1] - sums[mid - 1] + sums[r + k - 1] - sums[r - 1];
            if(curMax > maxSum) {
                maxSum = curMax;
                res[0] = l;
                res[1] = mid;
                res[2] = r;
            }
        }

        return res;
    }
}
