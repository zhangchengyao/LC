import java.util.List;

public class LC57_InsertInterval {
    class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0) intervals.add(newInterval);
        boolean mergeHappens = false;
        for(int i=0;i<intervals.size();i++){
            if(intervals.get(i).end>=newInterval.start){
                mergeHappens = true;
                if(intervals.get(i).start>newInterval.end){
                    intervals.add(i, newInterval);
                    break;
                }
                Interval merged = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
                intervals.remove(intervals.get(i));
                intervals.add(i, merged);
                while(i<intervals.size()-1 && intervals.get(i).end>=intervals.get(i+1).start){
                    merged = new Interval(intervals.get(i).start, Math.max(intervals.get(i).end, intervals.get(i+1).end));
                    intervals.remove(intervals.get(i+1));
                    intervals.remove(intervals.get(i));
                    intervals.add(i, merged);
                }
                break;
            }
        }
        if(!mergeHappens) intervals.add(intervals.size(), newInterval);
        return intervals;
    }
}
