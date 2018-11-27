public class LC363_MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m+1][n+1];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum[i+1][j+1] = sum[i][j+1]+sum[i+1][j]-sum[i][j]+matrix[i][j];
                for(int ii=0;ii<=i;ii++){
                    for(int jj=0;jj<=j;jj++){
                        int val = sum[i+1][j+1]-sum[ii][j+1]-sum[i+1][jj]+sum[ii][jj];
                        if(val==k) return k;
                        if(val>max && val<k) max = val;
                    }
                }
            }
        }
        return max;
    }
}
