public class LC414_ThirdMaximumNumber {
    class Solution {
        public int thirdMax(int[] nums) {
            int max1 = nums[0];
            int max2 = 0;
            int max3 = 0;
            boolean flag = false;
            int i = 0;
            for(;i<nums.length;i++){
                if(nums[i]!=max1){
                    max2 = nums[i];
                    flag = true;
                    break;
                }
            }
            if(!flag) return max1;
            flag = false;
            for(;i<nums.length;i++){
                if(nums[i]!=max1 && nums[i]!=max2){
                    max3 = nums[i];
                    flag = true;
                    break;
                }
            }
            if(!flag) return Math.max(max1, max2);
            if(max1<max2){
                int tmp = max1;
                max1 = max2;
                max2 = tmp;
            }
            if(max1<max3){
                int tmp = max1;
                max1 = max3;
                max3 = tmp;
            }
            if(max2<max3){
                int tmp = max2;
                max2 = max3;
                max3 = tmp;
            }
            for(;i<nums.length;i++){
                if(nums[i]>max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                }else if(nums[i]>max2){
                    if(nums[i]!=max1){
                        max3 = max2;
                        max2 = nums[i];
                    }
                }else if(nums[i]>max3){
                    if(nums[i]!=max2){
                        max3 = nums[i];
                    }
                }
            }
            return max3;
        }
    }
}
