import java.util.HashMap;
import java.util.TreeSet;

public class LC436_FindRightInterval {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int[] findRightInterval(Interval[] intervals) {
        TreeSet<Integer> tset = new TreeSet<>();
        HashMap<Integer, Interval> startToInterval = new HashMap<>();
        HashMap<Interval, Integer> map = new HashMap<>();
        for(int i=0;i<intervals.length;i++){
            tset.add(intervals[i].start);
            startToInterval.put(intervals[i].start, intervals[i]);
            map.put(intervals[i], i);
        }

        int[] rightIntervals = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            Integer rightStart = tset.ceiling(intervals[i].end);
            if(rightStart==null) rightIntervals[i] = -1;
            else{
                Interval right = startToInterval.get(rightStart);
                rightIntervals[i] = map.get(right);
            }
        }

        return rightIntervals;
    }
}
