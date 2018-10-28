import java.util.Arrays;
import java.util.Comparator;

public class LC435_NonOverlappingIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.end, i2.end);
            }
        });
        int cur = 0;
        int res = 0;
        int prev = 0;
        while(cur<intervals.length){
            if(cur==0) cur++;
            else{
                if(intervals[cur].start<intervals[prev].end){
                    cur++;
                    res++;
                }else{
                    prev = cur;
                    cur++;
                }
            }
        }
        return res;
    }
}
