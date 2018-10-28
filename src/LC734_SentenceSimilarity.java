import java.util.HashMap;
import java.util.HashSet;

public class LC734_SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length!=words2.length) return false;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(String[] pair: pairs){
            HashSet<String> set = map.getOrDefault(pair[0], new HashSet<String>());
            set.add(pair[1]);
            map.put(pair[0], set);
            set = map.getOrDefault(pair[1], new HashSet<String>());
            set.add(pair[0]);
            map.put(pair[1], set);
        }
        for(int i=0;i<words1.length;i++){
            if(!words1[i].equals(words2[i]) && !(map.get(words1[i])!=null && map.get(words1[i]).contains(words2[i]))) return false;
        }
        return true;
    }
}
