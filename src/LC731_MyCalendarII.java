import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LC731_MyCalendarII {
    // a clever solution
    private TreeMap<Integer, Integer> tmap;
    public LC731_MyCalendarII() {
        tmap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        tmap.put(start, tmap.getOrDefault(start, 0) + 1);
        tmap.put(end, tmap.getOrDefault(end, 0) - 1);
        int cnt = 0;
        for(int i: tmap.values()) {
            cnt += i;
            if(cnt == 3) break;
        }
        if(cnt == 3) {
            tmap.put(start, tmap.getOrDefault(start, 0) - 1);
            tmap.put(end, tmap.getOrDefault(end, 0) + 1);
            return false;
        } else {
            return true;
        }
    }

//    class Interval{
//        int start;
//        int end;
//        Interval(int s, int e){
//            start = s;
//            end = e;
//        }
//    }
//    private List<Interval> list;
//    private TreeMap<Integer, Integer> tmap; // stores double-booking interval
//
//    public LC731_MyCalendarII() {
//        list = new ArrayList<>();
//        tmap = new TreeMap<>();
//    }
//
//    public boolean book(int start, int end) {
//        if(list.isEmpty()){
//            list.add(new Interval(start, end));
//            return true;
//        }
//        Integer startBefore = tmap.floorKey(start);
//        Integer startAfter = tmap.ceilingKey(start);
//        boolean res = (startBefore == null || tmap.get(startBefore) <= start) && (startAfter == null || end <= startAfter);
//        if(res) {
//            for(Interval it: list) {
//                if(it.start >= end || start >= it.end) continue;
//                tmap.put(Math.max(start, it.start), Math.min(end, it.end));
//            }
//            list.add(new Interval(start, end));
//            return true;
//        } else return false;
//    }
}
