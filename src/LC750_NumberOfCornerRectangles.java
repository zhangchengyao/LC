import java.util.Arrays;

public class LC750_NumberOfCornerRectangles {
    // much faster solution
//    public int countCornerRectangles(int[][] grid) {
//        if(grid == null || grid.length == 0) return 0;
//        int[] ones = new int[grid[0].length];
//        int res = 0;
//        for(int i = 0; i < grid.length; i++){
//            Arrays.fill(ones, 0);
//            for(int j = 0; j < grid[0].length; j++){
//                if(grid[i][j] == 1) ones[j] = 1;
//            }
//            for(int j = i + 1; j < grid.length; j++){
//                int cnt = 0;
//                for(int k = 0; k < ones.length; k++){
//                    if(ones[k] == 1 && grid[j][k] == 1) cnt++;
//                }
//                res += cnt * (cnt - 1) / 2;
//            }
//        }
//        return res;
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
