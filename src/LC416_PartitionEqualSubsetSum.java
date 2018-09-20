import java.util.HashMap;

public class LC416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int half = sum/2;
        if(half*2!=sum) return false;
        return check(nums, nums.length-1, half, new HashMap<>());
    }
    private boolean check(int[] nums, int end, int sum, HashMap<String, Boolean> map){
        String state = end+" "+sum;
        if(map.containsKey(state)) return map.get(state);
        if(sum<=0) return false;
        if(end==0) return nums[end]==sum;
        boolean res = check(nums, end-1, sum, map)||check(nums, end-1, sum-nums[end], map);
        map.put(state, res);
        return res;
    }
}
