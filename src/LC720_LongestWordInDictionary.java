public class LC720_LongestWordInDictionary {
    class Node {
        String word;
        Node[] children;
        Node() {
            children = new Node[26];
        }
    }

    private String res = "";

    public String longestWord(String[] words) {
        Node root = new Node();
        for(String word: words) {
            Node cur = root;
            for(char c: word.toCharArray()) {
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];
            }

            cur.word = word;
        }

        for(Node node: root.children) {
            dfs(node);
        }

        return res;
    }

    private void dfs(Node root) {
        if(root == null || root.word == null) return ;

        if(root.word.length() > res.length()) res = root.word;
        for(Node child: root.children) {
            dfs(child);
        }
    }
}
