public class LC581_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length < 2) return 0;

        int i = 0;
        while(i < nums.length - 1 && nums[i] <= nums[i+1]) i ++;
        if(i == nums.length - 1) return 0;

        int min = Integer.MAX_VALUE;
        for(int k = i + 1; k < nums.length; k++){
            if(nums[k] < min) min = nums[k];
        }

        while(i >= 0 && nums[i] > min) i--;

        int j = nums.length - 1;
        while(j > 0 && nums[j] >= nums[j-1]) j--;

        int max = Integer.MIN_VALUE;
        for(int k = j - 1; k >= 0; k--){
            if(nums[k] > max) max = nums[k];
        }

        while(j < nums.length && nums[j] < max) j++;

        return j - i - 1;
    }
}
