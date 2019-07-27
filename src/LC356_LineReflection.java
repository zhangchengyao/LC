import java.util.HashMap;
import java.util.TreeSet;

public class LC356_LineReflection {
    public boolean isReflected(int[][] points) {
        if(points == null) return false;

        HashMap<Integer, TreeSet<Integer>> group = new HashMap<>();
        for(int[] point: points) {
            int y = point[1];
            group.putIfAbsent(y, new TreeSet<>());
            group.get(y).add(point[0]);
        }

        Double line = null;
        for(TreeSet<Integer> xs: group.values()) {
            while(!xs.isEmpty()) {
                int a = xs.first();
                int b = xs.last();
                if(line == null) {
                    line = (a + b) / 2.0;
                } else {
                    if((a + b) / 2.0 != line) return false;
                    xs.pollFirst();
                    if(a != b) xs.pollLast();
                }
            }
        }

        return true;
    }
}
