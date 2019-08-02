import java.util.List;

public class LC469_ConvexPolygon {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long prev = 0;
        long cur;
        for(int i = 0; i < n; i++) {
            int x1 = points.get((i + 1) % n).get(0) - points.get(i).get(0);
            int y1 = points.get((i + 1) % n).get(1) - points.get(i).get(1);
            int x2 = points.get((i + 2) % n).get(0) - points.get((i + 1) % n).get(0);
            int y2 = points.get((i + 2) % n).get(1) - points.get((i + 1) % n).get(1);

            cur = x1 * y2 - y1 * x2;
            if(cur != 0) {
                if(cur * prev < 0) return false;
                prev = cur;
            }
        }

        return true;
    }
}
