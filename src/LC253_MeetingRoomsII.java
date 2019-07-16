import java.util.*;

public class LC253_MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
         Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] x, int[] y) {
//                return x[0] - y[0];
//            }
//        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int number = 0;
        for(int[] meeting: intervals) {
            if(pq.isEmpty() || meeting[0] < pq.peek()) {
                number++;
            } else {
                pq.poll();
            }
            pq.offer(meeting[1]);
        }

        return number;
    }
//    class Interval{
//        int start, end;
//        Interval(int start, int end) {
//        this.start = start;
//        this.end = end;
//        }
//    }
//    public int minMeetingRooms(List<Interval> intervals) {
//        intervals.sort(new Comparator<Interval>() {
//            public int compare(Interval i, Interval j) {
//                return i.start == j.start ? i.end - j.end : i.start - j.start;
//            }
//        });
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        minHeap.offer(intervals.get(0).end);
//        int res = 1;
//        for(int i=1;i<intervals.size();i++){
//            if(intervals.get(i).start<minHeap.peek()){
//                res++;
//            }else{
//                minHeap.poll();
//            }
//            minHeap.offer(intervals.get(i).end);
//        }
//        return res;
//    }
}
