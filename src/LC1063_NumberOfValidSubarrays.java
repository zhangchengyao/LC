public class LC1063_NumberOfValidSubarrays {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int[] firstSmallerRight = new int[n];

        int res = 0;
        for(int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while(j < n && nums[j] >= nums[i]) {
                j = firstSmallerRight[j];
            }
            firstSmallerRight[i] = j;
            res += j - i;
        }

        return res;
    }
}
