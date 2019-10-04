public class LC861_ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[] zeroCnt = new int[n];

        for(int i = 0; i < m; i++) {
            if(A[i][0] == 0) {
                for(int j = 0; j < n; j++) {
                    A[i][j] ^= 1;
                }
            }
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 0) zeroCnt[j]++;
            }
        }

        for(int j = 1; j < n; j++) {
            if(zeroCnt[j] * 2 > m) {
                for(int i = 0; i < m; i++) {
                    A[i][j] ^= 1;
                }
            }
        }

        int score = 0;
        for (int[] row : A) {
            for (int j = 0; j < n; j++) {
                score += row[j] * (1 << (n - j - 1));
            }
        }

        return score;
    }
}
