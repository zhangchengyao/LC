import java.util.*;

public class LC715_RangeModule {
    class Range {
        int left;
        int right;
        Range(int l, int r) {
            left = l;
            right = r;
        }
    }

    private TreeSet<Range> tset;

    public LC715_RangeModule() {
        tset = new TreeSet<>(Comparator.comparingInt(a -> a.right));
    }

    public void addRange(int left, int right) {
        Range cur = tset.ceiling(new Range(0, left));
        while(cur != null && cur.left <= right) {
            left = Math.min(left, cur.left);
            right = Math.max(right, cur.right);
            tset.remove(cur);
            cur = tset.higher(cur);
        }
        tset.add(new Range(left, right));
    }

    public boolean queryRange(int left, int right) {
        Range cur = tset.ceiling(new Range(left, right));
        return cur != null && cur.left <= left;
    }

    public void removeRange(int left, int right) {
        Range cur = tset.higher(new Range(0, left));
        while(cur != null && cur.left < right) {
            tset.remove(cur);
            if(cur.left < left) tset.add(new Range(cur.left, left));
            if(cur.right > right) tset.add(new Range(right, cur.right));
            cur = tset.higher(cur);
        }
    }
}
