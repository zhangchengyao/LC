import java.util.HashMap;
import java.util.List;

public class LC737_SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;

        HashMap<String, String> parent = new HashMap<>();
        for(List<String> pair: pairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            parent.putIfAbsent(w1, w1);
            parent.putIfAbsent(w2, w2);
        }

        for(List<String> pair: pairs) {
            union(parent, pair.get(0), pair.get(1));
        }

        for(int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if(!w1.equals(w2) && !(parent.containsKey(w1) && parent.containsKey(w2) && find(parent, w1).equals(find(parent, w2)))) return false;
        }

        return true;
    }

    private void union(HashMap<String, String> parent, String a, String b) {
        String root1 = find(parent, a);
        String root2 = find(parent, b);
        if(root1.equals(root2)) return;
        parent.put(root1, root2);
    }

    private String find(HashMap<String, String> parent, String a) {
        while(!a.equals(parent.get(a))) {
            parent.put(a, parent.get(parent.get(a)));
            a = parent.get(a);
        }

        return a;
    }
}
