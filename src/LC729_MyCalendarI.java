import java.util.TreeMap;

public class LC729_MyCalendarI {
    TreeMap<Integer, Integer> tmap;
    public LC729_MyCalendarI() {
        tmap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(tmap.isEmpty()){
            tmap.put(start, end);
            return true;
        }
        System.out.println(start);
        Integer startBefore = tmap.floorKey(start);
        Integer startAfter = tmap.ceilingKey(start);
        boolean res = (startBefore==null||tmap.get(startBefore)<=start) && (startAfter==null||startAfter>=end);
        if(res) tmap.put(start, end);
        return res;
    }
}
