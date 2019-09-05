import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC1061_LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String A, String B, String S) {
        char[] parent = new char[26];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = (char)(i + 'a');
        }

        for(int i = 0; i < A.length(); i++) {
            union(parent, A.charAt(i), B.charAt(i));
        }

        StringBuilder sb = new StringBuilder(S);
        for(int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, find(parent, sb.charAt(i)));
        }

        return sb.toString();
    }

    private char find(char[] parent, char c) {
        while(parent[c - 'a'] != c) {
            c = parent[c - 'a'];
        }

        return c;
    }

    private void union(char[] parent, char x, char y) {
        char root1 = find(parent, x);
        char root2 = find(parent, y);

        if(root1 < root2) {
            parent[root2 - 'a'] = root1;
        } else if(root1 > root2) {
            parent[root1 - 'a'] = root2;
        }
    }

//    public String smallestEquivalentString(String A, String B, String S) {
//        HashMap<Character, List<Character>> graph = new HashMap<>();
//        for(int i = 0; i < A.length(); i++) {
//            char a = A.charAt(i);
//            char b = B.charAt(i);
//            graph.putIfAbsent(a, new ArrayList<>());
//            graph.putIfAbsent(b, new ArrayList<>());
//            graph.get(a).add(b);
//            graph.get(b).add(a);
//        }
//
//        char[] represent = new char[26];
//        for(int i = 0; i < 26; i++){
//            represent[i] = (char)(i + 'a');
//        }
//
//        for(int i = 0; i < 26; i++) {
//            if(represent[i] == (char)(i + 'a')) {
//                HashSet<Character> visited = new HashSet<>();
//                dfs(graph, represent[i], visited, represent, represent[i]);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder(S);
//        for(int i = 0; i < sb.length(); i++) {
//            sb.setCharAt(i, represent[sb.charAt(i) - 'a']);
//        }
//        return sb.toString();
//    }
//
//    private void dfs(HashMap<Character, List<Character>> graph, char cur, HashSet<Character> visited, char[] represent, char rep) {
//        if(visited.contains(cur)) return ;
//
//        visited.add(cur);
//        represent[cur - 'a'] = rep;
//
//        if(graph.get(cur) != null) {
//            for(char c: graph.get(cur)) {
//                dfs(graph, c, visited, represent, rep);
//            }
//        }
//    }
}
