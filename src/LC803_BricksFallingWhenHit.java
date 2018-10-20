public class LC803_BricksFallingWhenHit {
    // running time might be high
    int num;
    int cnt = 0;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        if(grid.length==0 || hits.length==0) return res;
        int[] xDirect = new int[]{0, 0, 1, -1};
        int[] yDirect = new int[]{1, -1, 0, 0};
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<hits.length;i++){
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y]==1){
                grid[x][y] = 0;
                for(int t=0;t<4;t++){
                    cnt++;
                    num = 0;
                    int r = x + xDirect[t];
                    int c = y + yDirect[t];
                    if(!check(grid, r, c, visited)){
                        res[i] += num;
                        cnt++;
                        drop(grid, r, c, visited);
                    }
                }

            }
            else res[i] = 0;
        }
        return res;
    }
    private boolean check(int[][] grid, int i, int j, int[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || visited[i][j]==cnt || grid[i][j]==0) return false;
        if(i==0 && grid[i][j]==1) return true;
        num++;
        visited[i][j] = cnt;
        return check(grid, i-1, j, visited) || check(grid, i+1, j, visited) || check(grid, i, j-1, visited) || check(grid, i, j+1, visited);
    }
    private void drop(int[][] grid, int i, int j, int[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || visited[i][j]==cnt || grid[i][j]==0) return;
        visited[i][j] = cnt;
        grid[i][j] = 0;
        drop(grid, i-1, j, visited);
        drop(grid, i+1, j, visited);
        drop(grid, i, j-1, visited);
        drop(grid, i, j+1, visited);
    }
}
