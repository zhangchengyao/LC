import java.util.ArrayList;
import java.util.List;

public class LC212_WordSearchII {

    class Node{
        String word;
        Node[] children;
        Node(){
            word = null;
            children = new Node[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Node root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, Node p, List<String> res){
        char c = board[i][j];
        if(c=='*') return;
        Node cur = p.children[c-'a'];
        if(cur==null) return;
        else{
            if(cur.word!=null){
                res.add(cur.word);
                cur.word = null;
            }
        }

        board[i][j] = '*';
        if(i>0) dfs(board, i-1, j, cur, res);
        if(i<board.length-1) dfs(board, i+1, j, cur, res);
        if(j>0) dfs(board, i, j-1, cur, res);
        if(j<board[0].length-1) dfs(board, i, j+1, cur, res);
        board[i][j] = c;
    }

    private Node buildTrie(String[] words){
        Node root = new Node();
        for(String word: words){
            Node cur = root;
            for(char c: word.toCharArray()){
                if(cur.children[c-'a']==null){
                    cur.children[c-'a'] = new Node();
                }
                cur = cur.children[c-'a'];
            }
            cur.word = word;
        }
        return root;
    }
}
