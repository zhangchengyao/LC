import java.util.HashMap;
import java.util.Map;

public class LC666_PathSumIV {
    private int res = 0;

    public int pathSum(int[] nums) {
        Map<Integer, Integer> treeMap = new HashMap<>();
        for(int n: nums) {
            treeMap.put(n / 10, n % 10);
        }

        getSum(11, treeMap, 0);
        return res;
    }

    private void getSum(int pos, Map<Integer, Integer> treeMap, int sum) {
        if(!treeMap.containsKey(pos)) return ;

        sum += treeMap.get(pos);
        int left = (pos / 10 + 1) * 10 + (pos % 10) * 2 - 1;
        int right = (pos / 10 + 1) * 10 + (pos % 10) * 2;
        if(!treeMap.containsKey(left) && !treeMap.containsKey(right)) {
            res += sum;
        } else {
            getSum(left, treeMap, sum);
            getSum(right, treeMap, sum);
        }
    }
}
