import java.util.HashMap;
import java.util.PriorityQueue;

public class LC506_RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
            q.offer(nums[i]);
        }
        int rank = nums.length;
        String[] res = new String[nums.length];
        while(!q.isEmpty()){
            int cur = q.poll();
            if(rank==1){
                res[map.get(cur)] = "Gold Medal";
            }else if(rank==2){
                res[map.get(cur)] = "Silver Medal";
            }else if(rank==3){
                res[map.get(cur)] = "Bronze Medal";
            }else{
                res[map.get(cur)] = rank+"";
            }
            rank--;
        }
        return res;
    }
}
