import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC127_WordLadder {
    class Vertex{
        String val;
        ArrayList<Vertex> edges;
        boolean visited;

        Vertex(String val){
            this.val = val;
            edges = new ArrayList<>();
            visited = false;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Vertex[] vertices = null;
        if(wordList.contains(beginWord)) vertices = new Vertex[wordList.size()];
        else  vertices = new Vertex[wordList.size()+1];
        vertices[0] = new Vertex(beginWord);
        int i = 1;
        for(String word:wordList){
            if(!word.equals(beginWord)) vertices[i++] = new Vertex(word);
        }
        for(i=0;i<vertices.length-1;i++){
            for(int j=i+1;j<vertices.length;j++){
                if(diff(vertices[i].val, vertices[j].val)==1){
                    vertices[i].edges.add(vertices[j]);
                    vertices[j].edges.add(vertices[i]);
                }
            }
        }
        Queue<Vertex> q = new LinkedList<>();
        q.offer(vertices[0]);
        vertices[0].visited  = true;
        int hops = 1;
        int num = 1;
        while(!q.isEmpty()){
            Vertex cur = q.poll();
            if(cur.val.equals(endWord)) return hops;
            for(Vertex v:cur.edges){
                if(!v.visited){
                    q.offer(v);
                    v.visited = true;
                }
            }
            num--;
            if(num==0){
                hops += 1;
                num = q.size();
            }
        }
        return 0;
    }
    int diff(String str1, String str2){
        int diff = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)) diff++;
        }
        return diff;
    }
}
