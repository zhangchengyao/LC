import java.util.HashMap;

public class LC835_ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] dist = new int[N * 2][N * 2];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(A[i][j] == 0) continue;

                for(int s = 0; s < N; s++) {
                    for(int t = 0; t < N; t++) {
                        if(B[s][t] == 0) continue;

                        dist[i - s + N][j - t + N]++;
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0; i < dist.length; i++) {
            for(int j = 0; j < dist.length; j++) {
                res = Math.max(res, dist[i][j]);
            }
        }

        return res;
    }
}
