import java.util.ArrayList;
import java.util.List;

public class LC228_SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i<nums.length){
            int j = i+1;
            while(j<nums.length && nums[j]==nums[j-1]+1) j++;
            if(j==i+1) res.add(nums[i]+"");
            else res.add(nums[i]+"->"+nums[j-1]);
            i = j;
        }
        return res;
    }
}
