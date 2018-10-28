import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC140_WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();
        return wordBreakRec(s, wordDict, map);
    }
    private List<String> wordBreakRec(String s, List<String> dict, HashMap<String, List<String>> map){
        List<String> res = new ArrayList<>();
        if(s.equals("")){
            res.add("");
            return res;
        }
        if(map.containsKey(s)) return map.get(s);
        for(String word:dict){
            if(word.length()<=s.length() && word.equals(s.substring(0, word.length()))){
                List<String> subres = wordBreakRec(s.substring(word.length()), dict, map);
                for(String str:subres){
                    StringBuilder sb = new StringBuilder(word);
                    sb.append(" ");
                    sb.append(str);
                    res.add(sb.toString().trim());
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
