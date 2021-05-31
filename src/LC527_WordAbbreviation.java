import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC527_WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> res = new ArrayList<>();
        if(dict == null || dict.isEmpty()) return res;

        HashMap<String, String> abbr2word = new HashMap<>();
        HashMap<String, String> word2abbr = new HashMap<>();
        boolean finish = false;
        int prefixLen = 1;
        while(!finish) {
            finish = true;
            for(String word: dict) {
                if(word.length() < 4 || word2abbr.containsKey(word) || prefixLen >= word.length() - 2) continue;

                String abbr = word.substring(0, prefixLen) + (word.length() - prefixLen - 1) + word.charAt(word.length() - 1);
                if(abbr2word.containsKey(abbr)) {
                    finish = false;
                    word2abbr.remove(abbr2word.get(abbr));
                } else {
                    abbr2word.put(abbr, word);
                    word2abbr.put(word, abbr);
                }
            }
            prefixLen++;
        }

        for(String word: dict) {
            res.add(word2abbr.getOrDefault(word, word));
        }

        return res;
    }
}