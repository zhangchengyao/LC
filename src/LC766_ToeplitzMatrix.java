public class LC766_ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return true;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]!=matrix[i-1][j-1]) return false;
            }
        }
        return true;
    }
}
