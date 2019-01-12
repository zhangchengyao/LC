import java.util.Map;
import java.util.TreeMap;

public class LC327_CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Long> sumCount = new TreeMap<>();
        int cnt = 0;

        sumCount.put(0L, 1L);
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            Map<Long, Long> subMap = sumCount.subMap(sum-upper, true, sum-lower, true);
            if(subMap!=null){
                for(long num: subMap.values()){
                    cnt += num;
                }
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0L)+1);
        }

        return cnt;
    }
}
