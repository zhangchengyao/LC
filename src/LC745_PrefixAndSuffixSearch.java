import java.util.HashMap;
import java.util.Map;

public class LC745_PrefixAndSuffixSearch {
    class Node{
        String word;
        int weight;
        Node[] children;
        Node(){
            children = new Node[26];
        }
    }
    private Node prefixRoot;
    private Node suffixRoot;

    public LC745_PrefixAndSuffixSearch(String[] words) {
        prefixRoot = new Node();
        suffixRoot = new Node();
        int w = 0;
        for(String word: words){
            Node cur = prefixRoot;
            for(int i = 0; i < word.length(); i++){
                if(cur.children[word.charAt(i) - 'a'] == null){
                    cur.children[word.charAt(i) - 'a'] = new Node();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.word = word;
            cur.weight = w;
            cur = suffixRoot;
            for(int i = word.length() - 1; i >= 0; i--){
                if(cur.children[word.charAt(i) - 'a'] == null){
                    cur.children[word.charAt(i) - 'a'] = new Node();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.word = word;
            cur.weight = w;
            w++;
        }
    }

    public int f(String prefix, String suffix) {
        Map<String, Integer> map = new HashMap<>(); // word => weight
        Node cur = prefixRoot;
        for(int i = 0; i < prefix.length(); i++){
            cur = cur.children[prefix.charAt(i) - 'a'];
            if(cur == null) return -1;
        }
        if(cur.word != null) map.put(prefix, cur.weight);
        for(Node child: cur.children){
            if(child != null) dfs(child, map);
        }

        Map<String, Integer> map2 = new HashMap<>();
        cur = suffixRoot;
        for(int i = suffix.length() - 1; i >= 0; i--){
            cur = cur.children[suffix.charAt(i) - 'a'];
            if(cur == null) return -1;
        }
        if(cur.word != null) map2.put(suffix, cur.weight);
        for(Node child: cur.children){
            if(child != null) dfs(child, map2);
        }

        int max = -1;
        for(String word: map.keySet()) {
            if(map2.containsKey(word)) max = Math.max(max, map.get(word));
        }
        return max;
    }
    private void dfs(Node cur, Map<String, Integer> map){
        if(cur == null) return;
        if(cur.word != null) map.put(cur.word, cur.weight);
        for(Node child: cur.children)
            if(child != null) dfs(child, map);
    }
}
