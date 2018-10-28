import java.util.Arrays;

public class LC169_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

        // a genius method
//         int major=nums[0], count = 1;
//         for(int i=1; i<nums.length;i++){
//             if(count==0){
//                 count++;
//                 major=nums[i];
//             }else if(major==nums[i]){
//                 count++;
//             }else count--;

//         }
//         return major;
    }
}
