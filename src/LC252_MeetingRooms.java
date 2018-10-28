import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC252_MeetingRooms {
    class Interval {
        int start, end;
        Interval(int start, int end) {
        this.start = start;
        this.end = end;
        }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i, Interval j){
                return i.start==j.start?i.end-j.end:i.start-j.start;
            }
        });
        for(int i=0;i<intervals.size()-1;i++){
            if(intervals.get(i).end>intervals.get(i+1).start) return false;
        }
        return true;
    }
}
