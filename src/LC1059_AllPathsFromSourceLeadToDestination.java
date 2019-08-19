import java.util.ArrayList;
import java.util.List;

public class LC1059_AllPathsFromSourceLeadToDestination {
    enum State {
        VISITING, VISITED
    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            if(graph[from] == null) graph[from] = new ArrayList<>();
            graph[from].add(to);
        }

        State[] states = new State[n];

        return dfs(graph, states, source, destination);
    }

    private boolean dfs(List<Integer>[] graph, State[] states, int cur, int dest) {
        if(states[cur] == State.VISITING) return false;
        if(cur == dest) {
            return graph[dest] == null;
        }
        if(graph[cur] == null) return false;

        states[cur] = State.VISITING;
        for(int child: graph[cur]) {
            if(!dfs(graph, states, child, dest)) return false;
        }
        states[cur] = State.VISITED;

        return true;
    }
}
