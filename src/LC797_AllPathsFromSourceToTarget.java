import java.util.ArrayList;
import java.util.List;

public class LC797_AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int[][] graph, int cur, List<Integer> path, List<List<Integer>> res) {
        path.add(cur);

        if(cur == graph.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for(int neighbor: graph[cur]) {
                dfs(graph, neighbor, path, res);
            }
        }

        path.remove(path.size() - 1);
    }
}
