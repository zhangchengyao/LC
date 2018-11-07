import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC341_FlattenNestedListIterator implements Iterator<Integer> {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    List<Integer> list;
    int cur;
    public LC341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for(NestedInteger ni: nestedList) flatten(list, ni);
        cur = 0;
    }
    private void flatten(List<Integer> res, NestedInteger nestedInteger){
        if(nestedInteger.isInteger()){
            res.add(nestedInteger.getInteger());
            return ;
        }
        for(NestedInteger ni: nestedInteger.getList()) flatten(res, ni);
    }

    @Override
    public Integer next() {
        return list.get(cur++);
    }

    @Override
    public boolean hasNext() {
        return cur!=list.size();
    }
}
