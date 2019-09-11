public class LC1121_DivideArrayIntoIncreasingSequences {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int mostFreq = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            while(j < nums.length && nums[j] == nums[i]) j++;
            mostFreq = Math.max(mostFreq, j - i);
            i = j;
        }

        return mostFreq * K <= nums.length;
    }
}
