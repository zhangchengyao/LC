import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC1136_ParallelCourses {
    public int minimumSemesters(int N, int[][] relations) {
        ArrayList<Integer>[] graph = new ArrayList[N];
        int[] in = new int[N];
        for(int[] relation: relations) {
            int from = relation[0];
            int to = relation[1];
            in[to - 1]++;
            if(graph[from - 1] == null) graph[from - 1] = new ArrayList<>();
            graph[from - 1].add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < in.length; i++) {
            if(in[i] == 0) q.offer(i + 1);
        }
        int numSem = 0;
        while(!q.isEmpty()) {
            int cnt = q.size();
            for(int i = 0; i < cnt; i++) {
                int cur = q.poll();
                if(graph[cur - 1] != null) {
                    for(int neighbor: graph[cur - 1]) {
                        in[neighbor - 1]--;
                        if(in[neighbor - 1] == 0) q.offer(neighbor);
                    }
                }
            }
            numSem++;
        }

        for(int n: in) {
            if(n != 0) return -1;
        }

        return numSem;
    }
}
