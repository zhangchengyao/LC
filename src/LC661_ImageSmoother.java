public class LC661_ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] direcs = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };

        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int sum = 0;
                int cnt = 0;
                for(int[] dir: direcs) {
                    if(isValid(i + dir[0], j + dir[1], m, n)) {
                        sum += M[i + dir[0]][j + dir[1]];
                        cnt++;
                    }
                }
                res[i][j] = sum / cnt;
            }
        }

        return res;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
