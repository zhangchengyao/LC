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
            for(int i=0;i<sentence.length();i++){
                char c = sentence.charAt(i);
                if(cur.children[c]==null){
                    cur.children[c] = new Node(c);
                }
                cur = cur.children[c];
            }
            if(cur.isSentence) cur.hot += times;
            else{
                cur.isSentence = true;
                cur.hot = times;
            }
        }
        List<String> startsWith(String str){
            List<Sentence> list = new ArrayList<>();
            List<String> res = new ArrayList<>();
            Node cur = root;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(cur.children[c]==null){
                    return res;
                }
                cur = cur.children[c];
            }
            if(cur.isSentence) list.add(new Sentence(str, cur.hot));
            for(Node child: cur.children){
                if(child!=null) dfs(child, str, list);
            }
            for(Sentence sentence: list) res.add(sentence.s);
            return res;
        }
        void dfs(Node cur, String str, List<Sentence> res){
            if(cur==null) return;
            if(cur.isSentence){
                int i = 0;
                for(;i<res.size();i++){
                    if(cur.hot>res.get(i).hot || (cur.hot==res.get(i).hot && (str+cur.val).compareTo(res.get(i).s)<0)){
                        res.add(i, new Sentence(str+cur.val, cur.hot));
                        break;
                    }
                }
                if(i==res.size() && res.size()<3) res.add(new Sentence(str+cur.val, cur.hot));
                if(res.size()>3) res.remove(res.size()-1);
            }
            for(Node child: cur.children){
                if(child!=null) dfs(child, str+cur.val, res);
            }
        }
    }
    class Node{
        char val;
        boolean isSentence;
        int hot;
        Node[] children;
        Node(){
            isSentence = false;
            children = new Node[130];
        }
        Node(char c){
            val = c;
            isSentence = false;
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

    Trie trie;
    StringBuilder input;
    public LC642_DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        input = new StringBuilder();
        for(int i=0;i<sentences.length;i++){
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c=='#'){
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
