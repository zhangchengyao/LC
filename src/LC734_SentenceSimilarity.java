import java.util.*;

public class LC734_SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;

        Map<String, Set<String>> sim = new HashMap<>();
        for(List<String> pair: pairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            sim.putIfAbsent(word1, new HashSet<>());
            sim.get(word1).add(word2);
            sim.putIfAbsent(word2, new HashSet<>());
            sim.get(word2).add(word1);
        }

        for(int i = 0; i < words1.length; i++) {
            if(!words1[i].equals(words2[i]) && (!sim.containsKey(words1[i]) || !sim.get(words1[i]).contains(words2[i]))) return false;
        }

        return true;
    }
}
