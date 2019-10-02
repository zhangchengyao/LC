import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC851_LoudAndRich {
    private int[] ans;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ans = new int[n];
        Arrays.fill(ans, -1);

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] pair: richer) {
            graph[pair[1]].add(pair[0]);
        }

        for(int i = 0; i < n; i++) {
            if(ans[i] == -1) dfs(graph, quiet, i);
        }

        return ans;
    }

    private int dfs(List<Integer>[] graph, int[] quiet, int person) {
        if(ans[person] != -1) return ans[person];

        int res = person;
        for(int neighbor: graph[person]) {
            int cand = dfs(graph, quiet, neighbor);
            if(quiet[res] > quiet[cand]) res = cand;
        }

        ans[person] = res;
        return res;
    }
}
