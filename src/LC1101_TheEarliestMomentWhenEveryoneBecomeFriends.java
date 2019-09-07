import java.util.Arrays;
import java.util.Comparator;

public class LC1101_TheEarliestMomentWhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        int[] parent = new int[N];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        for(int[] log: logs) {

            int a = log[1];
            int b = log[2];
            if(union(parent, a, b)) {
                cnt++;
            }
            if(cnt == N - 1) return log[0];
        }

        return -1;
    }

    private int find(int[] parent, int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    private boolean union(int[] parent, int x, int y) {
        int root1 = find(parent, x);
        int root2 = find(parent, y);
        if(root1 == root2) {
            return false;
        }
        parent[root1] = root2;
        return true;
    }
}
