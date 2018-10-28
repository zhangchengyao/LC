import java.util.HashSet;
import java.util.Set;

public class LC128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])) continue;
            int val = nums[i]+1;
            int len = 1;
            while(set.contains(val)){
                set.remove(val);
                val++;
                len++;
            }
            val = nums[i]-1;
            while(set.contains(val)){
                set.remove(val);
                val--;
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
