import java.util.HashMap;

public class LC1133_LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int largest = -1;
        for(int key: map.keySet()) {
            if(map.get(key) == 1) {
                largest = Math.max(largest, key);
            }
        }

        return largest;
    }
}
