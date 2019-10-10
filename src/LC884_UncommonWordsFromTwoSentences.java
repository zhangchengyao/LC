import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC884_UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: A.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(String word: B.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for(String word: map.keySet()) {
            if(map.get(word) == 1) list.add(word);
        }

        return list.toArray(new String[0]);
    }
}
