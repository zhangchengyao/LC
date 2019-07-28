import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC425_WordSquares {
    // todo
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;

        HashMap<Integer, HashMap<Character, HashSet<String>>> map = preprocess(words);

        construct(words, res, new ArrayList<>(), map);
        return res;
    }

    private void construct(String[] words, List<List<String>> res, List<String> tmp, HashMap<Integer, HashMap<Character, HashSet<String>>> map) {
        if(!tmp.isEmpty() && tmp.size() == tmp.get(0).length()) {
            res.add(new ArrayList<>(tmp));
            return ;
        }

        if(tmp.isEmpty()) {
            for (String word : words) {
                tmp.add(word);
                construct(words, res, tmp, map);
                tmp.remove(0);
            }
        } else {
            HashSet<String> candidates = null;
            int n = tmp.size();
            for(int i = 0; i < n; i++) {
                char c = tmp.get(i).charAt(n);
                HashSet<String> group = map.get(i).get(c);
                if(group == null) {
                    candidates = null;
                    break;
                }
                if(candidates == null) {
                    candidates = new HashSet<>(group);
                } else {
                    candidates.retainAll(group);
                }
            }

            if(candidates != null) {
                for(String str: candidates) {
                    tmp.add(str);
                    construct(words, res, tmp, map);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private HashMap<Integer, HashMap<Character, HashSet<String>>> preprocess(String[] words) {
        HashMap<Integer, HashMap<Character, HashSet<String>>> res = new HashMap<>();

        for(String word: words) {
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                res.putIfAbsent(i, new HashMap<>());
                res.get(i).putIfAbsent(c, new HashSet<>());
                res.get(i).get(c).add(word);
            }
        }

        return res;
    }
}
