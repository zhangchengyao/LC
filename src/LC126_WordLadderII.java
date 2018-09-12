import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC126_WordLadderII {
    class Vertex{
        String val;
        ArrayList<Vertex> edges;
        boolean visited;
        int layer;

        Vertex(String val){
            this.val = val;
            edges = new ArrayList<>();
            visited = false;
            layer = 0;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(!wordList.contains(endWord)) return res;
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
        vertices[0].layer = 0;
        int num = 1;
        boolean found = false;
        Vertex cur = null;
        int layer = 1;
        while(!q.isEmpty()){
            cur = q.poll();
            if(cur.val.equals(endWord)){
                found = true;
                break;
            }
            for(Vertex v:cur.edges){
                if(!v.visited){
                    q.offer(v);
                    v.visited = true;
                    v.layer = layer;
                }
            }
            num--;
            if(num==0){
                num = q.size();
                layer++;
            }
        }
        if(found){
            backtrack(res, new ArrayList<String>(), cur, beginWord);
        }
        return res;
    }
    private void backtrack(List<List<String>> res, List<String> tmp, Vertex v, String beginWord){
        tmp.add(0, v.val);
        if(v.val.equals(beginWord)){
            List<String> l = new ArrayList<>(tmp);
            res.add(l);
            return;
        }
        for(Vertex vertex:v.edges){
            if(vertex.visited==true && vertex.layer<v.layer){
                backtrack(res, tmp, vertex, beginWord);
                tmp.remove(0);
            }
        }
    }
    private int diff(String str1, String str2){
        int diff = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)) diff++;
        }
        return diff;
    }
}
