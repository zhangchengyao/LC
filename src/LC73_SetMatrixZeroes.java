public class LC73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean has0firstR = false;
        boolean has0firstC = false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0) has0firstR = true;
                    if(j==0) has0firstC = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0) matrix[i][j] = 0;
            }
        }
        if(has0firstR){
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i] = 0;
        }
        if(has0firstC){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0] = 0;
        }
    }
}
