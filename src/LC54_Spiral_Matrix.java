import java.util.ArrayList;
import java.util.List;

public class LC54_Spiral_Matrix {
    // a recursive solution
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        spiralRec(matrix, 0, 0, m, n, res);
        return res;
    }
    private void spiralRec(int[][] matrix, int row, int column, int rowSize, int columnSize, List<Integer> res){
        if(rowSize<=0 || columnSize<=0) return;
        if(rowSize == 1){
            for(int i=0;i<columnSize;i++){
                res.add(matrix[row][column+i]);
            }
        }
        else if(columnSize==1){
            for(int i=0;i<rowSize;i++){
                res.add(matrix[row+i][column]);
            }
        }
        else{
            // go right
            for(int j=0;j<columnSize;j++){
                res.add(matrix[row][column+j]);
            }
            // go down
            for(int i=1;i<rowSize;i++){
                res.add(matrix[row+i][column+columnSize-1]);
            }
            // go left
            for(int j=1;j<columnSize;j++){
                res.add(matrix[row+rowSize-1][column+columnSize-1-j]);
            }
            // go up
            for(int i=1;i<rowSize-1;i++){
                res.add(matrix[row+rowSize-1-i][column]);
            }
            spiralRec(matrix, row+1, column+1, rowSize-2, columnSize-2, res);
        }
    }
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> res = new ArrayList<Integer>();
//        if(matrix==null || matrix.length==0) return res;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[][] visited = new int[m][n];
//        int i = 0;
//        int j = 0;
//        while(true){
//            if((i==0 || visited[i-1][j]==1)
//                    && (i==m-1 || visited[i+1][j]==1)
//                    && (j==0 || visited[i][j-1]==1)
//                    && (j==n-1 || visited[i][j+1]==1)){
//                if(visited[i][j]==0) res.add(matrix[i][j]);
//                break;
//            }
//            // at the upper left corner
//            if((i==0 || visited[i-1][j]==1) && (j==0 || visited[i][j-1]==1) && j!=n-1 && visited[i][j+1]==0){
//                if(visited[i][j]==0){
//                    visited[i][j] = 1;
//                    res.add(matrix[i][j]);
//                }
//                // go right
//                while(!(j==n-1 || visited[i][j+1]==1)){
//                    j++;
//                    visited[i][j] = 1;
//                    res.add(matrix[i][j]);
//                }
//            }
//            // at the upper right corner
//            else if((i==0 || visited[i-1][j]==1) && (j==n-1 || visited[i][j+1]==1) && i!=m-1 && visited[i+1][j]==0){
//                if(visited[i][j]==0){
//                    visited[i][j] = 1;
//                    res.add(matrix[i][j]);
//                }
//                // go down
//                while(!(i==m-1 || visited[i+1][j]==1)){
//                    i++;
//                    visited[i][j] = 1;
//                    res.add(matrix[i][j]);
//                }
//            }
//            // at the lower right corner
//            else if((i==m-1 || visited[i+1][j]==1) && (j==n-1 || visited[i][j+1]==1) && j!=0 && visited[i][j-1]==0){
//                if(visited[i][j]==0){
//                    visited[i][j] = 1;
//                    res.add(matrix[i][j]);
//                }
//                // go left
//                while(!(j==0 || visited[i][j-1]==1)){
//                    j--;
//                    visited[i][j] = 1;
//                    res.add(matrix[i][j]);
//                }
//            }
//            // at the lower left corner
//            else{
//                if(visited[i][j]==0){
//                    visited[i][j] = 1;
//                    res.add(matrix[i][j]);
//                }
//                // go up
//                while(!(i==0 || visited[i-1][j]==1)){
//                    i--;
//                    visited[i][j] = 1;
//                    res.add(matrix[i][j]);
//                }
//            }
//        }
//        return res;
//    }
}
