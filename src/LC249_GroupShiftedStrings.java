import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class LC249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings){
        HashMap<String, TreeSet<String>> map  = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            String cur = strings[i];
            char first = cur.charAt(0);
            StringBuilder tmp = new StringBuilder();
            for(int j=1;j<cur.length();j++){
                tmp.append(((cur.charAt(j)-first)+26)%26).append(" ");
            }
            if(map.containsKey(tmp.toString())) map.get(tmp.toString()).add(cur);
            else{
                TreeSet<String> ts = new TreeSet<>();
                ts.add(cur);
                map.put(tmp.toString(), ts);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(TreeSet<String> ts: map.values()){
            List<String> item = new ArrayList<>(ts);
            res.add(item);
        }
        return res;
    }
}
