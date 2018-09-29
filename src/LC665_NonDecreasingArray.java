public class LC665_NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int local = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                if(i==1) nums[i-1] = nums[i];
                else{
                    if(nums[i-2]<nums[i]) nums[i-1] = nums[i];
                    else nums[i] = nums[i-1];
                }
                local++;
            }
            if(local>1) return false;
        }
        return true;
    }
}
