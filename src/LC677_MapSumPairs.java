public class LC677_MapSumPairs {
    class TrieNode {
        String word;
        int val;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public LC677_MapSumPairs() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        for(char c: key.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = key;
        cur.val = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for(char c: prefix.toCharArray()) {
            if(cur.children[c - 'a'] == null) return 0;
            cur = cur.children[c - 'a'];
        }
        return dfs(cur);
    }

    private int dfs(TrieNode root) {
        if(root == null) return 0;

        int res = root.word == null ? 0 : root.val;
        for(TrieNode child: root.children) {
            res += dfs(child);
        }
        return res;
    }
}
