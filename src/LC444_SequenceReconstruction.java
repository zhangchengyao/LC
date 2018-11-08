import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC444_SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        ArrayList<Integer>[] graph = new ArrayList[org.length+1];
        int[] in = new int[org.length+1];
        for(List<Integer> seq: seqs){
            for(int i=0;i<seq.size();i++){
                if(seq.get(i)<1 || seq.get(i)>org.length) return false;
                if(graph[seq.get(i)]==null) graph[seq.get(i)] = new ArrayList<>();
                if(i<seq.size()-1){
                    if(seq.get(i+1)<1 || seq.get(i+1)>org.length) return false;
                    graph[seq.get(i)].add(seq.get(i+1));
                    in[seq.get(i+1)]++;
                }
            }
        }
        int idx = -1;
        for(int i=1;i<graph.length;i++){
            if(graph[i]==null) return false;
            if(in[i]==0){
                if(idx==-1) idx = i;
                else return false;
            }
        }
        if(idx==-1) return false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while(!q.isEmpty()){
            if(q.size()>1) return false;
            int cur = q.poll();
            for(int to: graph[cur]){
                in[to]--;
                if(in[to]==0) q.offer(to);
            }
        }
        for(int i=1;i<in.length;i++){
            if(in[i]!=0) return false;
        }
        return true;
    }
}
