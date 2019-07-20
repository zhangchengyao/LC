import java.util.ArrayList;
import java.util.List;

public class LC281_ZigzagIterator {
    List<Integer> list;
    int cur;
    public LC281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();
        int i = 0;
        while(i < v1.size() && i < v2.size()){
            list.add(v1.get(i));
            list.add(v2.get(i++));
        }
        while(i < v1.size()) list.add(v1.get(i++));
        while(i < v2.size()) list.add(v2.get(i++));
        cur = 0;
    }

    public int next() {
        return list.get(cur++);
    }

    public boolean hasNext() {
        return cur != list.size();
    }
}
