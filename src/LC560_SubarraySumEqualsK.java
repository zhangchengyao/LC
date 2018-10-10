import java.util.HashMap;

public class LC560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // cumulated sum => num of this sum
        int sum = 0;
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)) res += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
    // dynamic programming with rolling array (slow)
//    public int subarraySum(int[] nums, int k) {
//        int[] dp = new int[nums.length];
//        int res = 0;
//        for(int i=0;i<dp.length;i++){
//            dp[i] = nums[i];
//            if(dp[i]==k) res++;
//        }
//        for(int len = 2;len<=nums.length;len++){
//            for(int i=nums.length-len;i>=0;i--){
//                dp[i+len-1] = dp[i+len-2]+nums[i+len-1];
//                if(dp[i+len-1]==k) res++;
//            }
//        }
//        return res;
//    }
}
