import java.util.*;

public class LC391_PerfectRectangle {
    class Point{
        int x;
        int y;
        Point(int _x, int _y){
            x = _x;
            y = _y;
        }
        public int hashCode(){
            return (x*31)^y;
        }
        public boolean equals(Object o){
            if(o instanceof Point){
                Point p = (Point)o;
                return p.x==x && p.y==y;
            }
            return false;
        }
        boolean leftAndBelow(Point p){
            return x<=p.x && y<=p.y;
        }
        boolean rightAndAbove(Point p){
            return x>=p.x && y>=p.y;
        }
    }
    public boolean isRectangleCover(int[][] rectangles) {
        long area = 0;
        Point bottomLeft = null;
        Point topRight = null;
        HashSet<Point> set = new HashSet<>();
        for(int[] rect: rectangles){
            Point downLeft = new Point(rect[0], rect[1]);
            Point upLeft = new Point(rect[0], rect[3]);
            Point downRight = new Point(rect[2], rect[1]);
            Point upRight = new Point(rect[2], rect[3]);

            area += (upRight.y-downLeft.y) * (upRight.x-downLeft.x);
            if(bottomLeft==null || downLeft.leftAndBelow(bottomLeft)) bottomLeft = downLeft;
            if(topRight==null || upRight.rightAndAbove(topRight)) topRight = upRight;

            Point[] points = {downLeft, upLeft, downRight, upRight};
            for(Point p: points){
                if(set.contains(p)) set.remove(p);
                else set.add(p);
            }
        }

        // pay attention to this case [[0,0,1,1],[0,0,2,1],[1,0,2,1],[0,2,2,3]]
        if(!set.contains(bottomLeft) || !set.contains(topRight) || set.size()!=4) return false;

        long totalArea = (topRight.y-bottomLeft.y) * (topRight.x-bottomLeft.x);
        return totalArea == area;
    }
}
