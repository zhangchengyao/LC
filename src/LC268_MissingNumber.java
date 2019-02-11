public class LC268_MissingNumber {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(i != nums[i] && nums[i] < nums.length){
                swap(nums, i, nums[i]);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i != nums[i]) return i;
        }

        return nums.length;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
