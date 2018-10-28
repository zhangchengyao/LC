import java.util.ArrayList;
import java.util.List;

public class LC229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0) return res;

        int m1 = 0;
        int m2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int num: nums){
            if(num==m1) count1++;
            else if(num==m2) count2++;
            else if(count1==0){
                m1 = num;
                count1++;
            }
            else if(count2==0){
                m2 = num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int num: nums){
            if(num==m1) count1++;
            else if(num==m2) count2++;
        }
        if(count1>nums.length/3) res.add(m1);
        if(count2>nums.length/3) res.add(m2);
        return res;
    }
}
