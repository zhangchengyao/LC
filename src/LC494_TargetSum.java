import java.util.HashMap;

public class LC494_TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        HashMap<String, Integer> map = new HashMap<>();
        return findRec(nums, 0, nums.length-1, S, map);
    }
    private int findRec(int[] nums, int left, int right, int S, HashMap<String, Integer> map){
        String cur = left+" "+right+" "+S;
        if(map.containsKey(cur)) return map.get(cur);
        if(left==right) {
            if(nums[left]==0 && S==0){
                map.put(cur, 2);
                return 2;
            }
            if(nums[left]==S || nums[left]==-S){
                map.put(cur, 1);
                return 1;
            }else{
                map.put(cur, 0);
                return 0;
            }
        }
        int s1 = findRec(nums, left, right-1, S-nums[right], map);
        int s2 = findRec(nums, left, right-1, S+nums[right], map);
        map.put(cur, s1+s2);
        return s1+s2;
    }
}
