import java.util.HashMap;
import java.util.List;

public class LC364_NestedListWeightSumII {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private int maxLevel = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(NestedInteger ni: nestedList) {
            groupIntegers(ni, 1, map);
        }
        int sum = 0;
        for(int level: map.keySet()) {
            sum += map.get(level) * (maxLevel - level + 1);
        }
        return sum;
    }

    private void groupIntegers(NestedInteger ni, int level, HashMap<Integer, Integer> map) {
        if(ni.isInteger()) {
            maxLevel = Math.max(maxLevel, level);
            map.put(level, map.getOrDefault(level, 0) + ni.getInteger());
            return;
        }
        for(NestedInteger child: ni.getList()) {
            groupIntegers(child, level + 1, map);
        }
    }
}
