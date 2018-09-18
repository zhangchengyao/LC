import java.util.HashMap;
import java.util.List;

public class LC139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRec(s, wordDict, new HashMap<String, Boolean>());
    }
    private boolean wordBreakRec(String s, List<String> dict, HashMap<String, Boolean> map){
        if(s.equals("")) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i=1;i<=s.length();i++){
            if(dict.contains(s.substring(0,i)) && wordBreakRec(s.substring(i), dict, map)){
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
