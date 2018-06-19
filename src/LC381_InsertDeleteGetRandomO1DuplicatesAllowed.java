import java.util.*;

public class LC381_InsertDeleteGetRandomO1DuplicatesAllowed {
    Map<Integer, Set<Integer>> locs;
    List<Integer> nums;
    /** Initialize your data structure here. */
    public LC381_InsertDeleteGetRandomO1DuplicatesAllowed() {
        locs = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        if(!locs.containsKey(val)){
            locs.put(val, new HashSet<>());
            locs.get(val).add(nums.size()-1);
            return true;
        }else{
            // already contains this element
            locs.get(val).add(nums.size()-1);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(locs.containsKey(val)){
            int index = locs.get(val).iterator().next();
            int lastElement = nums.get(nums.size()-1);
            locs.get(val).remove(index);
            if(index!=nums.size()-1){
                // the element is not the last element
                // then swap it with the last element
                locs.get(lastElement).add(index);
                locs.get(lastElement).remove(nums.size()-1);
                nums.set(index, lastElement);
            }
            if(locs.get(val).isEmpty()){
                locs.remove(val);
            }
            nums.remove(nums.size()-1);
            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(new Random().nextInt(nums.size()));
    }
}
