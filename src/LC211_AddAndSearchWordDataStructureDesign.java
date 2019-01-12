import java.util.HashMap;

public class LC211_AddAndSearchWordDataStructureDesign {
    class Trie{
        Node root;

        Trie(){
            root = new Node('*');
        }

        void insert(String word){
            root.insert(word, 0);
        }

        boolean search(String word){
            return root.search(word, 0);
        }
    }

    class Node{
        char val;
        boolean isWord;
        HashMap<Character, Node> children;
        Node(char _val){
            val = _val;
            isWord = false;
            children = new HashMap<>();
        }

        void insert(String str, int idx){
            if(idx==str.length()){
                isWord = true;
                return ;
            }

            char c = str.charAt(idx);
            children.putIfAbsent(c, new Node(c));
            children.get(c).insert(str, idx+1);
        }

        boolean search(String str, int idx){
            if(idx==str.length()){
                return isWord;
            }

            char c = str.charAt(idx);
            if(c!='.'){
                if(children.get(c)==null) return false;
                return children.get(c).search(str, idx+1);
            } else {
                for(Node child: children.values()){
                    if(child.search(str, idx+1)) return true;
                }
                return false;
            }

        }
    }

    private Trie trie;

    /** Initialize your data structure here. */
    public LC211_AddAndSearchWordDataStructureDesign() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}
