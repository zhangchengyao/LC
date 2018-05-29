public class LC240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        for(int i=0;i<matrix.length;i++){
            if(binarySearch(matrix[i], target)) return true;
        }
        return false;
    }
    private boolean binarySearch(int[] input, int target){
        int left = 0;
        int right = input.length-1;
        int middle;
        while(left<=right){
            middle = (left+right)/2;
            if(input[middle]==target) return true;
            else if(input[middle]>target) right = middle - 1;
            else left = middle + 1;
        }
        return false;
    }
}
