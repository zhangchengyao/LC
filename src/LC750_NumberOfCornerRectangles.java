import java.util.Arrays;

public class LC750_NumberOfCornerRectangles {
    // much faster solution
//    public int countCornerRectangles(int[][] grid) {
//        int cnt = 0;
//        int m = grid.length;
//        int n = grid[0].length;
//        for(int i = 0; i < m; i++) {
//            for(int r = i + 1; r < m; r++) {
//                int num = 0;
//                for(int j = 0; j < n; j++) {
//                    if(grid[i][j] == 1 && grid[r][j] == 1) num++;
//                }
//
//                cnt += (num - 1) * num / 2;
//            }
//        }
//
//        return cnt;
//    }

    // naive solution
    public int countCornerRectangles(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int k = j + 1;
                    while(k < grid[0].length){
                        if(grid[i][k] == 1){
                            int r = i + 1;
                            while(r < grid.length){
                                if(grid[r][j] == 1 && grid[r][k] == 1) res++;
                                r++;
                            }
                        }
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
