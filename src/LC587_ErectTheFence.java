import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC587_ErectTheFence {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    // Jarvis Algorithm
    public List<Point> outerTrees(Point[] points) {
        List<Point> border = new ArrayList<>();

        if(points.length < 4){
            border.addAll(Arrays.asList(points));
            return border;
        }

        int leftMost = getLeftMost(points);

        HashSet<Integer> set = new HashSet<>();

        int cur = leftMost;
        do{
            int q = (cur + 1) % points.length;
            for(int i = 0; i < points.length; i++){
                if(getOrientation(points[cur], points[i], points[q]) < 0){
                    q = i;
                }
            }

            for(int i = 0; i < points.length; i++){
                if(i != cur && i != q && getOrientation(points[cur], points[i], points[q]) == 0 && isBetween(points[cur], points[i], points[q])){
                    set.add(i);
                }
            }
            set.add(q);
            cur = q;
        } while (cur != leftMost);

        for(int index: set){
            border.add(points[index]);
        }

        return border;
    }

    private int getLeftMost(Point[] points){
        int res = 0;
        for(int i = 1; i < points.length; i++){
            if(points[i].x < points[res].x) res = i;
        }
        return res;
    }

    private int getOrientation(Point p, Point r, Point q){
        return (r.x - p.x) * (q.y - p.y) - (r.y - p.y) * (q.x - p.x);
    }

    private boolean isBetween(Point p, Point i, Point q){
        boolean x = (i.x >= p.x && i.x <= q.x) || (i.x >= q.x && i.x <= p.x);
        boolean y = (i.y >= p.y && i.y <= q.y) || (i.y >= q.y && i.y <= p.y);
        return x && y;
    }
}
