public class LC885_SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[R * C][2];

        int steps = 2;
        int r = r0;
        int c = c0;
        res[0] = new int[]{r, c};
        int i = 1;
        while(i < res.length) {
            r += directions[0][0];
            c += directions[0][1];
            if(valid(R, C, r, c)) res[i++] = new int[]{r, c};

            for(int s = 0; s < steps - 1; s++) {
                r += directions[1][0];
                c += directions[1][1];
                if(valid(R, C, r, c)) res[i++] = new int[]{r, c};
            }

            for(int d = 2; d <= directions.length; d++) {
                for(int s = 0; s < steps; s++) {
                    r += directions[d % directions.length][0];
                    c += directions[d % directions.length][1];
                    if(valid(R, C, r, c)) res[i++] = new int[]{r, c};
                }
            }

            steps += 2;
        }

        return res;
    }

    private boolean valid(int R, int C, int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
