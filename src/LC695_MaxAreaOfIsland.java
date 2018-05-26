public class LC695_MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] tag = new int[rows][columns];
        int max = 0;
        int val = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]==1 && tag[i][j]==0){
                    int area = mark(grid, tag, i, j, ++val);
                    if(area>max) max = area;
                }
            }
        }
        return max;
    }
    private int mark(int[][] grid, int[][] tag, int i, int j, int val){
        tag[i][j] = val;
        int res = 1;
        if(i>0 && grid[i-1][j]==1 && tag[i-1][j]==0){
            res += mark(grid, tag, i-1, j, val);
        }
        if(i<grid.length-1 && grid[i+1][j]==1 && tag[i+1][j]==0){
            res += mark(grid, tag, i+1, j, val);
        }
        if(j>0 && grid[i][j-1]==1 && tag[i][j-1]==0){
            res += mark(grid, tag, i, j-1, val);
        }
        if(j<grid[0].length-1 && grid[i][j+1]==1 && tag[i][j+1]==0){
            res += mark(grid, tag, i, j+1, val);
        }
        return res;
    }
}
