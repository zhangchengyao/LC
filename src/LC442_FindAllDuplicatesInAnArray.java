import java.util.ArrayList;
import java.util.List;

public class LC442_FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            if(nums[val-1]<0) res.add(val);
            else nums[val-1] = -nums[val-1];
        }
        return res;
    }
}
