import java.util.ArrayList;
import java.util.List;

public class LC802_FindEventualSafeStates {
    private int[] memo;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        memo = new int[graph.length];

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            if(memo[i] == 0) dfs(graph, i);
            if(memo[i] == 1) res.add(i);
        }

        return res;
    }

    private boolean dfs(int[][] graph, int cur) {
        if(memo[cur] == -1) return false;
        if(memo[cur] == 1) return true;

        memo[cur] = -1;
        for(int neighbor: graph[cur]) {
            if(!dfs(graph, neighbor)) {
                return false;
            }
        }

        memo[cur] = 1;
        return true;
    }
}
