public class LC361_BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int numRow = 0;
        int[] numCol = new int[grid[0].length];
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(j == 0 || grid[i][j-1] == 'W'){
                    numRow = 0;
                    for(int k = j; k < grid[0].length && grid[i][k] != 'W'; k++){
                        if(grid[i][k] == 'E') numRow++;
                    }
                }
                if(i == 0 || grid[i-1][j] == 'W'){
                    numCol[j] = 0;
                    for(int k = i; k < grid.length && grid[k][j] != 'W'; k++){
                        if(grid[k][j] == 'E') numCol[j]++;
                    }
                }
                if(grid[i][j] == '0') res = Math.max(res, numRow + numCol[j]);
            }
        }
        return res;
    }
}
