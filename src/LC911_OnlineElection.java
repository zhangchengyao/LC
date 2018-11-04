import java.util.HashMap;
import java.util.TreeMap;

public class LC911_OnlineElection {
    private TreeMap<Integer, Integer> leading;
    public LC911_OnlineElection(int[] persons, int[] times) {
        HashMap<Integer, Integer> map = new HashMap<>();
        leading = new TreeMap<>();
        map.put(persons[0], 1);
        leading.put(times[0], 0);
        int prevLeading = 0;
        for(int i=1;i<times.length;i++){
            map.put(persons[i], map.getOrDefault(persons[i], 0)+1);
            if(map.get(persons[i])>=map.get(prevLeading)){
                leading.put(times[i], persons[i]);
                prevLeading = persons[i];
            }
            else{
                leading.put(times[i], prevLeading);
            }
        }
    }

    public int q(int t) {
        return leading.floorEntry(t).getValue();
    }
}
