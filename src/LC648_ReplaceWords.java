import java.util.List;

public class LC648_ReplaceWords {
    class TrieNode {
        String word;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();

        for(String word: dict) {
            TrieNode cur = root;
            for(char c: word.toCharArray()) {
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        StringBuilder sb = new StringBuilder();
        for(String word: sentence.split(" ")) {
            TrieNode cur = root;
            boolean hasRoot = false;
            for(char c: word.toCharArray()) {
                if(cur.children[c - 'a'] == null) break;
                cur = cur.children[c - 'a'];
                if(cur.word != null) {
                    hasRoot = true;
                    break;
                }
            }
            if(hasRoot) sb.append(cur.word);
            else sb.append(word);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
