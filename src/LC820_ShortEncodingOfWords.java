public class LC820_ShortEncodingOfWords {
    class TrieNode {
        String word;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private int total = 0;

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode cur = root;
            for(int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        dfs(root);

        return total;
    }

    private void dfs(TrieNode root) {
        boolean isLeaf = true;
        for(TrieNode child: root.children) {
            if(child != null) {
                isLeaf = false;
                dfs(child);
            }
        }

        if(isLeaf) total += root.word.length() + 1;
    }
}
