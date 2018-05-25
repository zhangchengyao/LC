public class LC64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null) return -1;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;

                int minValue = 0;
                // reach grid[i][j] from the cell above
                if(isValid(i-1, j)){
                    minValue = grid[i-1][j] + grid[i][j];
                }else{
                    minValue = Integer.MAX_VALUE;
                }
                // reach grid[i][j] from the cell left
                if(isValid(i, j-1)){
                    minValue = Math.min(minValue, grid[i][j-1]+grid[i][j]);
                }
                grid[i][j] = minValue;
            }
        }

        return grid[m-1][n-1];
    }

    private boolean isValid(int i, int j){
        if(i>=0 && j>=0) return true;
        else return false;
    }
}
