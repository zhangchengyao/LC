class LC208_ImplementTrie_PrefixTree {

    class Node{
        char val;
        boolean isWord;
        Node[] children;
        Node(){
            isWord = false;
            children = new Node[26];
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public LC208_ImplementTrie_PrefixTree() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(int i=0;i<word.length();i++){
            if(cur.children[word.charAt(i)-'a']==null){
                cur.children[word.charAt(i)-'a'] = new Node();
                cur.children[word.charAt(i)-'a'].val = word.charAt(i);
            }
            cur = cur.children[word.charAt(i)-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        int i = 0;
        while(i<word.length() && cur.children[word.charAt(i)-'a']!=null){
            cur = cur.children[word.charAt(i)-'a'];
            i++;
        }
        return i == word.length() && cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        int i = 0;
        while(i<prefix.length() && cur.children[prefix.charAt(i)-'a']!=null){
            cur = cur.children[prefix.charAt(i)-'a'];
            i++;
        }
        return i == prefix.length();
    }
}

/**
 * Your LC208_ImplementTrie_PrefixTree object will be instantiated and called as such:
 * LC208_ImplementTrie_PrefixTree obj = new LC208_ImplementTrie_PrefixTree();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */