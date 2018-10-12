import java.util.HashMap;

public class LC737_SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length!=words2.length) return false;
        HashMap<String, String> parent = new HashMap<>();
        for(String[] pair: pairs){
            parent.put(pair[0], pair[0]);
            parent.put(pair[1], pair[1]);
        }
        for(String[] pair: pairs){
            union(pair[0], pair[1], parent);
        }
        for(int i=0;i<words1.length;i++){
            if(!words1[i].equals(words2[i]) && !(parent.containsKey(words1[i])&&parent.containsKey(words2[i])&&find(words1[i], parent).equals(find(words2[i], parent)))) return false;
        }
        return true;
    }
    private String find(String s, HashMap<String, String> parent){
        while(!parent.get(s).equals(s)){
            parent.put(s, parent.get(parent.get(s)));
            s = parent.get(s);
        }
        return s;
    }
    private void union(String a, String b, HashMap<String, String> parent){
        String root1 = find(a, parent);
        String root2 = find(b, parent);
        if(root1.equals(root2)) return;
        parent.put(root1, root2);
    }
}
