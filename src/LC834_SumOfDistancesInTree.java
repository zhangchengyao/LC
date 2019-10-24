import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC834_SumOfDistancesInTree {
    // difficult to think of
    private int[] ans;
    private int[] count;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) graph.add(new ArrayList<>());
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        dfs(graph, 0, -1);
        dfs2(graph, 0, -1);

        return ans;
    }

    private void dfs(List<List<Integer>> graph, int root, int parent) {
        for(int neighbor: graph.get(root)) {
            if(neighbor == parent) continue;
            dfs(graph, neighbor, root);
            count[root] += count[neighbor];
            ans[root] += ans[neighbor] + count[neighbor];
        }
    }

    private void dfs2(List<List<Integer>> graph, int root, int parent) {
        for(int neighbor: graph.get(root)) {
            if(neighbor == parent) continue;
            ans[neighbor] = ans[root] - count[neighbor] + graph.size() - count[neighbor];
            dfs2(graph, neighbor, root);
        }
    }
}
