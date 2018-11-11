import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int p = i+1;
            int q = nums.length-1;
            int sum = -nums[i];
            while(p<q){
                if(nums[p]+nums[q]==sum){
                    res.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    p++;
                    q--;
                    while(p<q && nums[p]==nums[p-1]) p++;
                    while(p<q && nums[q]==nums[q+1]) q--;
                }
                else if(nums[p]+nums[q]>sum){
                    q--;
                }
                else{
                    p++;
                }
            }
        }
        return res;
    }
}
