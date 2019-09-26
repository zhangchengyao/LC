public class LC807_MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowMax = new int[m];
        int[] colMax = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
            }
        }
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }

        return sum;
    }
}
