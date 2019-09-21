public class LC713_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int prod = 1;
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            prod *= nums[j++];
            while(i < j && prod >= k) {
                prod /= nums[i++];
            }
            res += j - i;
        }

        return res;
    }
}
