import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC380_InsertDeleteGetRandomO1 {
    List<Integer> nums;
    Map<Integer, Integer> loc;
    /** Initialize your data structure here. */
    public LC380_InsertDeleteGetRandomO1() {
        nums = new ArrayList<>();
        loc = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(loc.containsKey(val)) return false;
        nums.add(val);
        loc.put(val, nums.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(loc.containsKey(val)){
            int index = loc.get(val);
            if(index!=nums.size()-1){
                // this element is not the last one
                // then swap it with the last element
                nums.set(index, nums.get(nums.size()-1));
                loc.put(nums.get(nums.size()-1), index);
            }
            loc.remove(val);
            nums.remove(nums.size()-1);
            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int rd = (int)(Math.random() * nums.size());
        return nums.get(rd);
    }
}
