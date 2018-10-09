import java.util.ArrayList;
import java.util.List;

public class LC802_FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(dfs(i, color, graph)) res.add(i);
        }
        return res;
    }
    private boolean dfs(int i, int[] color, int[][] graph){
        // System.out.println("current i ="+i);
        if(color[i]==2) return true;
        if(color[i]==1) return false;
        color[i] = 1;
        for(int j=0;j<graph[i].length;j++){
            if(color[graph[i][j]]==1 || !dfs(graph[i][j], color, graph)) return false;
        }
        color[i] = 2;
        return true;
    }
}
