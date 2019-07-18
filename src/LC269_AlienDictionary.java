import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class LC269_AlienDictionary {
    // could be solved using topological sorting
    public String alienOrder(String[] words) {
        ArrayList<Character>[] graph = new ArrayList[26];
        int[] in = new int[26];
        for(String str: words){
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(graph[c-'a'] == null) graph[c-'a'] = new ArrayList<>();
            }
        }

        for(int i = 1; i < words.length; i++){
            int p = 0;
            while(p < words[i-1].length() &&  p< words[i].length() && words[i-1].charAt(p) == words[i].charAt(p)) p++;
            if(p == words[i-1].length() || p == words[i].length()) continue;
            char from = words[i-1].charAt(p);
            char to = words[i].charAt(p);
            int index1 = from - 'a';
            int index2 = to - 'a';
            graph[index1].add(to);
            in[index2]++;
        }
        for(int i = 0; i < graph.length; i++){
            if(graph[i] == null) in[i] = -1;
        }
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < in.length; i++){
            if(in[i] == 0) q.offer((char)(i+'a'));
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char cur = q.poll();
            sb.append(cur);
            if(graph[cur-'a'] == null) continue;
            for(char c: graph[cur-'a']){
                in[c-'a']--;
                if(in[c-'a'] == 0) q.offer(c);
            }
        }
        for(int i: in) if(i != 0 && i != -1) return "";
        return sb.toString();
    }
}
