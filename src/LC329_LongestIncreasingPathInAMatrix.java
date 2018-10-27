public class LC329_LongestIncreasingPathInAMatrix {
    int[][] maxInc;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        maxInc = new int[matrix.length][matrix[0].length];
        int res = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int inc = dfs(matrix, i, j);
                if(inc>res) res = inc;
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int i, int j){
        if(maxInc[i][j]>0) return maxInc[i][j];
        int res = 1;
        if(i>0 && matrix[i-1][j]>matrix[i][j]) res = Math.max(res, 1+dfs(matrix, i-1, j));
        if(i<matrix.length-1 && matrix[i+1][j]>matrix[i][j]) res = Math.max(res, 1+dfs(matrix, i+1, j));
        if(j>0 && matrix[i][j-1]>matrix[i][j]) res = Math.max(res, 1+dfs(matrix, i, j-1));
        if(j<matrix[0].length-1 && matrix[i][j+1]>matrix[i][j]) res = Math.max(res, 1+dfs(matrix, i, j+1));
        maxInc[i][j] = res;
        return res;
    }
}
