public class LC705_DesignHashSet {
    private boolean[] nums;
    /** Initialize your data structure here. */
    public LC705_DesignHashSet() {
        nums = new boolean[1000001];
    }

    public void add(int key) {
        nums[key] = true;
    }

    public void remove(int key) {
        nums[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return nums[key];
    }
}
