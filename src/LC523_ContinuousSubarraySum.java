import java.util.HashMap;

public class LC523_ContinuousSubarraySum {
//    public boolean checkSubarraySum(int[] nums, int k) {
//        if(nums.length < 2) return false;
//
//        for(int i = 0; i < nums.length - 1; i++){
//            int sum = nums[i];
//            for(int j = i + 1; j < nums.length; j++){
//                sum += nums[j];
//                if(k == 0){
//                    if(sum == 0) return true;
//                } else if(sum % k == 0) return true;
//            }
//        }
//
//        return false;
//    }

    // if a % c == b % c, then a - b is divisible by c
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int remainder = k == 0 ? sum : sum % k;
            if(map.get(remainder) == null){
                map.put(remainder, i);
            } else {
                if(map.get(remainder) < i - 1) return true;
            }
        }

        return false;
    }
}
