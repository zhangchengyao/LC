public class LC41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0) return 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]==i+1 || nums[i]>nums.length || nums[nums[i]-1]==nums[i]) continue;
            int tmp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = tmp;
            i--;
        }
        for(int i=0;i<nums.length;i++){
            if(i+1!=nums[i]) return i+1;
        }
        return nums.length+1;
    }
}
