public class LC1060_MissingElementInSortedArray {
    // binary search
    public int missingElement(int[] nums, int k) {
        if(k > missing(nums.length - 1, nums)) {
            return nums[nums.length - 1] + k - missing(nums.length - 1, nums);
        }

        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(k > missing(mid, nums)) left = mid + 1;
            else right = mid;
        }

        return nums[left - 1] + k - missing(left - 1, nums);
    }

    private int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    // linear search
//    public int missingElement(int[] nums, int k) {
//        int i = 0;
//        while(i < nums.length - 1) {
//            int gap = nums[i + 1] - nums[i] - 1;
//            if(k <= gap) {
//                return nums[i] + k;
//            }
//            i++;
//            k -= gap;
//        }
//
//        return nums[i] + k;
//    }
}
