import java.util.HashMap;
import java.util.TreeSet;

public class LC356_LineReflection {
    public boolean isReflected(int[][] points) {
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            TreeSet<Integer> tset = map.getOrDefault(point[1], new TreeSet<>());
            tset.add(point[0]);
            map.put(point[1], tset);
        }
        double mid = 0;
        boolean first = true;
        for (TreeSet<Integer> xs : map.values()) {
            while (!xs.isEmpty()) {
                if (xs.size() == 1) {
                    if (first) {
                        first = false;
                        mid = xs.pollFirst();
                    } else {
                        if (mid != xs.pollFirst()) return false;
                    }
                } else {
                    int a = xs.pollFirst();
                    int b = xs.pollLast();
                    if (first) {
                        first = false;
                        mid = (a + b) / 2.0;
                    } else {
                        if (mid != (a + b) / 2.0) return false;
                    }
                }
            }
        }
        return true;
    }
}
