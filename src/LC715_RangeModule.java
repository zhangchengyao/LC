import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LC715_RangeModule {
    //todo
    TreeMap<Integer, Integer> tmap;
    public LC715_RangeModule() {
        tmap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if(left>=right) return ;
        Integer start = tmap.floorKey(left);
        Integer end = tmap.floorKey(right);
        if(start==null && end==null){
            tmap.put(left, right);
        }
        else if(start!=null && tmap.get(start)>=left){
            tmap.put(start, Math.max(tmap.get(start), Math.max(tmap.get(end), right)));
        }
        else{
            tmap.put(left, Math.max(tmap.get(end), right));
        }
        Map<Integer, Integer> subMap = tmap.subMap(left, false, right ,true);
        Set<Integer> set = new HashSet<>(subMap.keySet());
        tmap.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        if(left>=right) return false;
        Integer start = tmap.floorKey(left);
        return start!=null && right<=tmap.get(start);
    }

    public void removeRange(int left, int right) {
        if(left>=right) return;
        Integer start = tmap.floorKey(left);
        Integer end = tmap.floorKey(right);
        if(end!=null && tmap.get(end)>right){
            tmap.put(right, tmap.get(end));
        }
        if(start!=null && tmap.get(start)>left){
            tmap.put(start, left);
        }
        Map<Integer, Integer> subMap = tmap.subMap(left, true, right, false);
        Set<Integer> set = new HashSet<>(subMap.keySet());
        tmap.keySet().removeAll(set);
    }
}
