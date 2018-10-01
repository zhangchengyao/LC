import java.util.HashMap;

public class LC532_KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int res = 0;
        if(k==0){
            for(int key:map.keySet()){
                if(map.get(key)>1) res++;
            }
        }else{
            for(int key:map.keySet()){
                if(map.containsKey(key+k) && map.get(key+k)!=-1) res++;
                if(map.containsKey(key-k) && map.get(key-k)!=-1) res++;
                map.put(key, -1);
            }
        }
        return res;
    }
}
