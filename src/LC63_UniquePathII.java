public class LC63_UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return -1;
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(i==0 && j==0){
                    if(obstacleGrid[i][j]==1)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = 1;
                    continue;
                }
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                    continue;
                }
                int num = 0;
                if(isValid(obstacleGrid, i-1, j)) num += dp[i-1][j];
                if(isValid(obstacleGrid, i, j-1)) num += dp[i][j-1];
                dp[i][j] = num;
            }
        }
        return dp[rows-1][columns-1];
    }

    private boolean isValid(int[][] obstacleGrid, int i, int j){
        if(i>=0 && j>=0 && obstacleGrid[i][j]==0)
            return true;
        else
            return false;
    }
}
