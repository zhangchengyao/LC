import java.util.HashSet;

public class LC565_ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = 0;
        int[] memo = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int len = longestPath(nums, i, 0, new HashSet<>(), memo);
            max = Math.max(max, len);
        }

        return max;
    }

    private int longestPath(int[] nums, int idx, int len, HashSet<Integer> set, int[] memo){
        if(set.contains(nums[idx])) return len;
        if(memo[idx] > 0) return memo[idx];

        set.add(nums[idx]);
        memo[idx] = longestPath(nums, nums[idx], len + 1, set, memo);
        return memo[idx];
    }
}
