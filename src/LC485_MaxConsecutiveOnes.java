public class LC485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current_max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(current_max>max) max = current_max;
                current_max = 0;
            }else{
                current_max++;
            }
        }
        return Math.max(max, current_max);
    }
}
