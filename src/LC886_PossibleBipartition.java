import java.util.*;

public class LC886_PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 1; i < graph.length; i++) graph[i] = new ArrayList<>();

        for(int[] dislike: dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] groups = new int[N + 1];
        Arrays.fill(groups, -1);

        for(int i = 1; i < graph.length; i++) {
            if(groups[i] != -1) continue;

            if(!bfs(graph, i, groups)) return false;
        }

        return true;
    }

    private boolean bfs(List<Integer>[] graph, int start, int[] groups) {
        int g = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        groups[start] = g;
        while(!q.isEmpty()) {
            int cnt = q.size();
            g ^= 1;
            for(; cnt > 0; cnt--) {
                int cur = q.poll();
                for(int neighbor: graph[cur]) {
                    if(groups[neighbor] == (g ^ 1)) return false;
                    if(groups[neighbor] == -1) {
                        groups[neighbor] = g;
                        q.offer(neighbor);
                    }
                }
            }
        }

        return true;
    }
}
