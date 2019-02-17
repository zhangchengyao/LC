import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC642_DesignSearchAutocompleteSystem {
    class Trie{
        Node root;

        Trie(){
            root = new Node();
        }

        void insert(String sentence, int times){
            Node cur = root;
            for(int i = 0; i < sentence.length(); i++){
                char c = sentence.charAt(i);
                if(cur.children[c] == null){
                    cur.children[c] = new Node(c);
                }
                cur = cur.children[c];
            }
            if(cur.sentence != null) cur.hot += times;
            else{
                cur.sentence = sentence;
                cur.hot = times;
            }
        }

        List<String> startsWith(String str){
            List<Sentence> list = new ArrayList<>();
            List<String> res = new ArrayList<>();

            Node cur = root;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(cur.children[c] == null){
                    return res;
                }
                cur = cur.children[c];
            }

            if(cur.sentence != null) list.add(new Sentence(cur.sentence, cur.hot));

            for(Node child: cur.children){
                if(child != null) dfs(child, list);
            }

            for(Sentence sentence: list) res.add(sentence.s);

            return res;
        }

        private void dfs(Node cur, List<Sentence> res){
            if(cur == null) return;

            if(cur.sentence != null){
                int i = 0;
                for(; i < res.size(); i++){
                    if(cur.hot > res.get(i).hot ||
                            (cur.hot == res.get(i).hot && cur.sentence.compareTo(res.get(i).s) < 0)){
                        res.add(i, new Sentence(cur.sentence, cur.hot));
                        break;
                    }
                }

                if(i == res.size() && res.size() < 3) res.add(new Sentence(cur.sentence, cur.hot));
                if(res.size() > 3) res.remove(res.size() - 1);
            }

            for(Node child: cur.children){
                if(child != null) dfs(child, res);
            }
        }
    }
    class Node{
        char val;
        String sentence;
        int hot;
        Node[] children;

        Node(){
            children = new Node[130];
        }
        Node(char c){
            val = c;
            children = new Node[130];
        }
    }
    class Sentence{
        String s;
        int hot;
        Sentence(String s, int hot){
            this.s = s;
            this.hot = hot;
        }
    }

    private Trie trie;
    private StringBuilder input;

    public LC642_DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        input = new StringBuilder();
        for(int i = 0; i < sentences.length; i++){
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#'){
            trie.insert(input.toString(), 1);
            input = new StringBuilder();
            return Arrays.asList();
        }
        else{
            input.append(c);
            return trie.startsWith(input.toString());
        }
    }
}
