import java.util.*;

public class LC850_RectangleAreaII {
    class Interval{
        long y;
        long left;
        long right;
        int tag; //0 denotes bottom line, 1 denotes top line
        Interval(long y, long left, long right, int tag){
            this.y = y;
            this.left = left;
            this.right = right;
            this.tag = tag;
        }
    }

    public int rectangleArea(int[][] rectangles) {
        long mod = 1_000_000_007;
        Interval[] intervals = new Interval[rectangles.length * 2];
        int i = 0;
        for(int[] rect: rectangles){
            intervals[i++] = new Interval(rect[1], rect[0], rect[2], 0);
            intervals[i++] = new Interval(rect[3], rect[0], rect[2], 1);
        }
        Arrays.sort(intervals, Comparator.comparingLong(a -> a.y));

        List<Interval> active = new ArrayList<>();
        long res = 0;
        long basey = intervals[0].y;
        for(Interval interval: intervals) {
            long len = 0;
            long cury = interval.y;
            long cur = -1;
            for(Interval ai: active) {
                cur = Math.max(cur, ai.left);
                len += Math.max(ai.right - cur, 0);
                cur = Math.max(cur, ai.right);
            }
            res += (len * (cury - basey)) % mod;
            res %= mod;
            if(interval.tag == 0) {
                active.add(interval);
                active.sort(Comparator.comparingLong(a -> a.left));
            } else {
                for(i = 0; i < active.size(); i++){
                    if(active.get(i).left == interval.left && active.get(i).right == interval.right){
                        active.remove(i);
                        break;
                    }
                }
            }
            basey = cury;
        }

        return (int)res;
    }
}
