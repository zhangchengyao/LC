import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC261_GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        HashSet<Integer> visited = new HashSet<>();
        return dfs(0, visited, graph, -1) && (visited.size() == n);
    }

    private boolean dfs(int cur, HashSet<Integer> visited, List<List<Integer>> graph, int parent) {
        if(visited.contains(cur)) return false;

        visited.add(cur);
        List<Integer> children = graph.get(cur);
        for(int child: children) {
            if(child == parent) continue;
            if(!dfs(child, visited, graph, cur)) return false;
        }

        return true;
    }
}
