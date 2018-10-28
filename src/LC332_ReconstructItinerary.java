import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LC332_ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String[] ticket: tickets){
            List<String> tset = map.getOrDefault(ticket[0], new ArrayList<>());
            tset.add(ticket[1]);
            map.put(ticket[0], tset);
        }
        for(List<String> list: map.values()) Collections.sort(list);
        res.add("JFK");
        findRec(map, "JFK", res);
        return res;
    }
    private boolean findRec(HashMap<String, List<String>> map, String cur, List<String> res){
        if(map.isEmpty()) return true;
        if(!map.containsKey(cur) || map.get(cur).isEmpty()) return false;
        List<String> dests = map.get(cur);
        for(int i=0;i<dests.size();i++){
            String tmp = dests.remove(i);
            res.add(tmp);
            if(dests.isEmpty()) map.remove(cur);
            if(findRec(map, tmp, res)) return true;
            dests.add(i, tmp);
            res.remove(res.size()-1);
            map.put(cur, dests);
        }
        return false;
    }
}
