public class LC747_LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int largestIdx = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[largestIdx]) largestIdx = i;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i == largestIdx) continue;
            if(nums[i] * 2 > nums[largestIdx]) return -1;
        }

        return largestIdx;
    }
}
