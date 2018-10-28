public class LC308_RangeSumQuery2DMutable {
    // use binary indexed tree
    int[][] matrix;
    int[][] bit;

    public LC308_RangeSumQuery2DMutable(int[][] matrix) {
        if(matrix==null || matrix.length==0) return ;
        this.matrix = new int[matrix.length+1][matrix[0].length+1];
        bit = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val-matrix[row+1][col+1];
        for(int i=row+1;i<matrix.length;i+=(i&-i)){
            for(int j=col+1;j<matrix[0].length;j+=(j&-j)){
                bit[i][j] += diff;
            }
        }
        matrix[row+1][col+1] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2+1, col2+1)-getSum(row2+1, col1)-getSum(row1, col2+1)+getSum(row1, col1);
    }
    private int getSum(int x, int y){
        int res = 0;
        for(int i=x;i>0;i-=(i&-i)){
            for(int j=y;j>0;j-=(j&-j)){
                res += bit[i][j];
            }
        }
        return res;
    }
}
