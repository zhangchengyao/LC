import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC1061_LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String A, String B, String S) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for(int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        char[] represent = new char[26];
        for(int i = 0; i < 26; i++){
            represent[i] = (char)(i + 'a');
        }

        for(int i = 0; i < 26; i++) {
            if(represent[i] == (char)(i + 'a')) {
                HashSet<Character> visited = new HashSet<>();
                dfs(graph, represent[i], visited, represent, represent[i]);
            }
        }

        StringBuilder sb = new StringBuilder(S);
        for(int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, represent[sb.charAt(i) - 'a']);
        }
        return sb.toString();
    }

    private void dfs(HashMap<Character, List<Character>> graph, char cur, HashSet<Character> visited, char[] represent, char rep) {
        if(visited.contains(cur)) return ;

        visited.add(cur);
        represent[cur - 'a'] = rep;

        if(graph.get(cur) != null) {
            for(char c: graph.get(cur)) {
                dfs(graph, c, visited, represent, rep);
            }
        }
    }
}
