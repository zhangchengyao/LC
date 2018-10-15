import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC253_MeetingRoomsII {
    class Interval{
        int start, end;
        Interval(int start, int end) {
        this.start = start;
        this.end = end;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i, Interval j){
                return i.start==j.start?i.end-j.end:i.start-j.start;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals.get(0).end);
        int res = 1;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start<minHeap.peek()){
                res++;
            }else{
                minHeap.poll();
            }
            minHeap.offer(intervals.get(i).end);
        }
        return res;
    }
}
