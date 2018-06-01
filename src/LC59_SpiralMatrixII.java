public class LC59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        generateRec(res, 0, 0, n, n, 1);
        return res;
    }
    private void generateRec(int[][] res, int row, int column, int rowSize, int columnSize, int start){
        if(rowSize<=0 || columnSize<=0) return;
        if(rowSize==1){
            for(int i=0;i<columnSize;i++){
                res[row][column+i] = start++;
            }
        }else if(columnSize==1){
            for(int i=0;i<rowSize;i++){
                res[row+i][column] = start++;
            }
        }else{
            // go right
            for(int i=0;i<columnSize;i++){
                res[row][column+i] = start++;
            }
            // go down
            for(int i=1;i<rowSize;i++){
                res[row+i][column+columnSize-1] = start++;
            }
            // go left
            for(int i=1;i<columnSize;i++){
                res[row+rowSize-1][column+columnSize-1-i] = start++;
            }
            // go up
            for(int i=1;i<rowSize-1;i++){
                res[row+rowSize-1-i][column] = start++;
            }
            generateRec(res, row+1, column+1, rowSize-2, columnSize-2, start);
        }
    }
}
