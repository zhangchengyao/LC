import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC890_FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;

        HashMap<Character, Character> map;

        for(String word: words){
            if(word.length() != pattern.length()) continue;
            map = new HashMap<>();

            int i = 0;
            for(; i < pattern.length(); i++){
                if(map.containsKey(word.charAt(i))) {
                    if(map.get(word.charAt(i)) != pattern.charAt(i)) break;
                } else {
                    if(map.containsValue(pattern.charAt(i))) break;
                    map.put(word.charAt(i), pattern.charAt(i));
                }
            }

            if(i == pattern.length()) res.add(word);
        }
        return res;
    }
}
