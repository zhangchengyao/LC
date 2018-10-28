import java.util.HashMap;

public class LC494_TargetSum {
    // dynamic programming
//    public int findTargetSumWays(int[] nums, int S) {
//        if(nums==null || nums.length==0) return 0;
//        int total = 0;
//        for(int i=0;i<nums.length;i++) total+=nums[i];
//        if((total+S)%2!=0 || total<Math.abs(S)) return 0;
//        int target = (total+S)/2;
//        int[] dp = new int[target+1];
//        dp[0] = 1;
//        for(int i=0;i<nums.length;i++){
//            for(int j=target;j>=nums[i];j--){
//                dp[j] += dp[j-nums[i]];
//            }
//        }
//        return dp[target];
//    }
    HashMap<String, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int S) {
        return findRec(nums, 0, S);
    }
    private int findRec(int[] nums, int left, int target){
        String str = left+" "+target;
        if(map.containsKey(str)) return map.get(str);
        if(left==nums.length-1){
            if(target==0 && nums[left]==0) return 2;
            if(nums[left]==target || nums[left]==-target) return 1;
            return 0;
        }
        int total = findRec(nums, left+1, target-nums[left])+findRec(nums, left+1, target+nums[left]);
        map.put(str, total);
        return total;
    }
}
