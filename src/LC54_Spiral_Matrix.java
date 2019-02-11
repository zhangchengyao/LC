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

    // iterative solution
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> res = new ArrayList<>();
//        if(matrix == null || matrix.length == 0) return res;
//
//        int width = matrix[0].length;
//        int height = matrix.length;
//        int startR = 0;
//        int startC = 0;
//
//        while(width > 0 && height > 0){
//            for(int i = startC; i < startC + width; i++){
//                res.add(matrix[startR][i]);
//            }
//            for(int i = startR + 1; i < startR + height; i++){
//                res.add(matrix[i][startC + width - 1]);
//            }
//            if(height > 1){
//                for(int i = startC + width - 2; i >= startC; i--){
//                    res.add(matrix[startR + height - 1][i]);
//                }
//            }
//            if(width > 1){
//                for(int i = startR + height - 2; i > startR; i--){
//                    res.add(matrix[i][startC]);
//                }
//            }
//
//            width -= 2;
//            height -= 2;
//            startR++;
//            startC++;
//        }
//
//        return res;
//    }
}
