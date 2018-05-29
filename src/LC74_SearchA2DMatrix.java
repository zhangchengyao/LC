public class LC74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row1 = 0;
        int row2 = m-1;
        // first locate row
        while(row1<=row2){
            int middle = (row1+row2)/2;
            if(matrix[middle][0]<=target && target<= matrix[middle][n-1]){
                row1 = middle;
                break;
            }else if(matrix[middle][0]>target){
                row2 = middle-1;
            }else{
                row1 = middle+1;
            }
        }
        if(row1>row2) return false;
        // row1 is the target row
        int c1 = 0;
        int c2 = n - 1;
        while(c1<=c2){
            int middle = (c1 + c2) / 2;
            if(matrix[row1][middle]==target) return true;
            else if(matrix[row1][middle]>target) c2 = middle - 1;
            else c1 = middle + 1;
        }
        return false;
    }
}
