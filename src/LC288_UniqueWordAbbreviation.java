import java.util.HashMap;
import java.util.HashSet;

public class LC288_UniqueWordAbbreviation {
    HashMap<String, HashSet<String>> map;
    public LC288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for(String dict: dictionary){
            if(dict.length()>=3){
                String abbre = dict.charAt(0)+""+(dict.length()-2)+dict.charAt(dict.length()-1);
                HashSet<String> set = map.getOrDefault(abbre, new HashSet<>());
                set.add(dict);
                map.put(abbre, set);
            }
        }
    }

    public boolean isUnique(String word) {
        if(word.length()<3) return true;
        else{
            String abbre = word.charAt(0)+""+(word.length()-2)+word.charAt(word.length()-1);
            return !map.containsKey(abbre) || (map.get(abbre).size()==1 && map.get(abbre).contains(word));
        }
    }
}
