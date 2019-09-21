public class LC724_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] sumsLeft = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            sumsLeft[i] = sumsLeft[i - 1] + nums[i - 1];
        }
        int[] sumsRight = new int[nums.length];
        for(int i = nums.length - 2; i >= 0; i--) {
            sumsRight[i] = sumsRight[i + 1] + nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++) {
            if(sumsLeft[i] == sumsRight[i]) return i;
        }

        return -1;
    }
}
