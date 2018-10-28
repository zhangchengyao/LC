import java.util.HashMap;

public class LC745_PrefixAndSuffixSearch {
    class Node{
        char val;
        boolean isWord;
        int weight;
        Node[] children;
        Node(){
            isWord = false;
            children = new Node[26];
        }
    }
    Node prefixRoot;
    Node suffixRoot;
    public LC745_PrefixAndSuffixSearch(String[] words) {
        prefixRoot = new Node();
        suffixRoot = new Node();
        int w = 0;
        for(String word: words){
            Node cur = prefixRoot;
            for(int i=0;i<word.length();i++){
                if(cur.children[word.charAt(i)-'a']==null){
                    cur.children[word.charAt(i)-'a'] = new Node();
                    cur.children[word.charAt(i)-'a'].val = word.charAt(i);
                }
                cur = cur.children[word.charAt(i)-'a'];
            }
            cur.isWord = true;
            cur.weight = w;
            cur = suffixRoot;
            for(int i=word.length()-1;i>=0;i--){
                if(cur.children[word.charAt(i)-'a']==null){
                    cur.children[word.charAt(i)-'a'] = new Node();
                    cur.children[word.charAt(i)-'a'].val = word.charAt(i);
                }
                cur = cur.children[word.charAt(i)-'a'];
            }
            cur.isWord = true;
            cur.weight = w;
            w++;
        }
    }

    public int f(String prefix, String suffix) {
        HashMap<String, Integer> map = new HashMap<>(); // word => weight
        Node cur = prefixRoot;
        for(int i=0;i<prefix.length();i++){
            cur = cur.children[prefix.charAt(i)-'a'];
            if(cur==null) return -1;
        }
        if(cur.isWord) map.put(prefix, cur.weight);
        for(Node child: cur.children){
            if(child!=null) dfs(prefix, child, map);
        }

        HashMap<String, Integer> map2 = new HashMap<>();
        cur = suffixRoot;
        for(int i=suffix.length()-1;i>=0;i--){
            cur = cur.children[suffix.charAt(i)-'a'];
            if(cur==null) return -1;
        }
        if(cur.isWord) map2.put(suffix, cur.weight);
        for(Node child: cur.children){
            if(child!=null) dfs(suffix, child, map2);
        }

        int max = -1;
        for(Integer weight: map.values()){
            for(Integer weight2: map2.values()){
                if(weight.equals(weight2)) max = Math.max(max, weight);
            }
        }
        return max;
    }
    private void dfs(String str, Node cur, HashMap<String, Integer> map){
        if(cur==null) return;
        if(cur.isWord) map.put(str+cur.val, cur.weight);
        for(Node child: cur.children)
            if(child!=null) dfs(str+cur.val, child, map);
    }
}
