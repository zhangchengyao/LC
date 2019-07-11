import java.util.HashMap;

public class LC170_TwoSumIIIDataStructureDesign {
    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public LC170_TwoSumIIIDataStructureDesign() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int num: map.keySet()) {
            if(map.containsKey(value - num)){
                if(num == value - num) {
                    if(map.get(num) > 1) return true;
                    else continue;
                }
                return true;
            }
        }
        return false;
    }
}