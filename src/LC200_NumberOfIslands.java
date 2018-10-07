public class LC200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null) return 0;
        if(grid.length==0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] tag = new int[rows][columns];
        int num = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1' && tag[i][j]==0){
                    mark(grid, tag, i, j, ++num);
                }
            }
        }
        return num;
    }
    private void mark(char[][] grid, int[][] tag, int i, int j, int val){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if(grid[i][j]=='0' || tag[i][j]!=0) return;
        tag[i][j] = val;
        mark(grid, tag, i-1, j, val);
        mark(grid, tag, i+1, j, val);
        mark(grid, tag, i, j-1, val);
        mark(grid, tag, i, j+1, val);
    }
}
