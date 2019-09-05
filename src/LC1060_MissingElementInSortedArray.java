public class LC1060_MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int i = 0;
        while(i < nums.length - 1) {
            int gap = nums[i + 1] - nums[i] - 1;
            if(k <= gap) {
                return nums[i] + k;
            }
            i++;
            k -= gap;
        }

        return nums[i] + k;
    }
}
