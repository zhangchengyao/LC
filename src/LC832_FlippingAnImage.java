public class LC832_FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int N = A.length;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < (N + 1) / 2; j++) {
                if((N & 1) == 1 && j == N / 2) {
                    A[i][j] ^= 1;
                } else {
                    int tmp = A[i][N - j - 1];
                    A[i][N - j - 1] = A[i][j] ^ 1;
                    A[i][j] = tmp ^ 1;
                }
            }
        }

        return A;
    }
}
