import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC632_SmallestRangeCoveringElementsFromKLists {
    class Pair {
        int id;
        int val;
        Pair(int _id, int _val) {
            id = _id;
            val = _val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        List<Pair> allNums = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.get(i).size(); j++) {
                allNums.add(new Pair(i, nums.get(i).get(j)));
            }
        }

        allNums.sort((a, b) -> a.val == b.val ? a.id - b.id : a.val - b.val);

        HashMap<Integer, Integer> map = new HashMap<>();
        int range = Integer.MAX_VALUE;
        int[] res = new int[2];
        int cnt = 0;
        int left = 0;
        int right = 0;
        while(right < allNums.size()) {
            Pair cur = allNums.get(right++);
            map.put(cur.id, map.getOrDefault(cur.id, 0) + 1);
            if(map.get(cur.id) == 1) cnt++;
            if(cnt == nums.size()) {
                while(cnt == nums.size()) {
                    cur = allNums.get(left++);
                    map.put(cur.id, map.get(cur.id) - 1);
                    if(map.get(cur.id) == 0) cnt--;
                }
                if(allNums.get(right - 1).val - allNums.get(left - 1).val < range) {
                    range = allNums.get(right - 1).val - allNums.get(left - 1).val;
                    res[0] = allNums.get(left - 1).val;
                    res[1] = allNums.get(right - 1).val;
                }
            }
        }

        return res;
    }
}
