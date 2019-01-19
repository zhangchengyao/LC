import java.util.*;

public class LC472_ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(Arrays.asList(words));
        HashMap<String, Boolean> memo = new HashMap<>();

        for(String word: words){
            if(isConcatenated(word, dict, memo, true)) res.add(word);
        }

        return res;
    }

    private boolean isConcatenated(String word, HashSet<String> dict, HashMap<String, Boolean> memo, boolean isOriginal){
        if(dict.contains(word) && !isOriginal) return true;
        if(memo.containsKey(word)) return memo.get(word);

        for(int i=1;i<word.length();i++){
            String leading = word.substring(0, i);
            if(dict.contains(leading)){
                String remaining = word.substring(i);
                if(isConcatenated(remaining, dict, memo, false)){
                    memo.put(word, true);
                    return true;
                }
            }
        }

        memo.put(word, false);
        return false;
    }
}
