import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC56_MergeIntervals {
    class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        for(int i=0;i<intervals.size();i++){
            if(i<intervals.size()-1 && intervals.get(i).end>=intervals.get(i+1).start){
                if(intervals.get(i).end<intervals.get(i+1).end){
                    Interval tmp = new Interval(intervals.get(i).start, intervals.get(i+1).end);
                    intervals.remove(i+1);
                    intervals.remove(i);
                    intervals.add(i, tmp);
                    i--;
                }
                else{
                    intervals.remove(i+1);
                    i--;
                }
            }
        }
        return intervals;
    }
}
