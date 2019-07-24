import java.util.List;

public class LC339_NestedListWeightSum {
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

    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;

        int sum = 0;
        for(NestedInteger ni: nestedList) {
            sum += helper(ni, 1);
        }
        return sum;
    }

    private int helper(NestedInteger ni, int depth) {
        if(ni.isInteger()) {
            return ni.getInteger() * depth;
        } else {
            int sum = 0;
            for(NestedInteger inner: ni.getList()) {
                sum += helper(inner, depth + 1);
            }
            return sum;
        }
    }
}
