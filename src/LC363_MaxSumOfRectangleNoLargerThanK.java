import java.util.Arrays;
import java.util.TreeSet;

public class LC363_MaxSumOfRectangleNoLargerThanK {
    // faster solution
//    public int maxSumSubmatrix(int[][] matrix, int k) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[] arr = new int[m];
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            Arrays.fill(arr, 0);
//            for(int j=i;j<n;j++){
//                for(int r=0;r<m;r++){
//                    arr[r] += matrix[r][j];
//                }
//                int cur = maxSum(arr, k);
//                if(cur>max) max = cur;
//            }
//        }
//        return max;
//    }
//    private int maxSum(int[] arr, int k){
//        int cum = 0;
//        int max = Integer.MIN_VALUE;
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(0);
//        for(int i=0;i<arr.length;i++){
//            cum += arr[i];
//            Integer cur = set.ceiling(cum-k);
//            if(cur!=null){
//                if(cum-cur>max) max = cum-cur;
//            }
//            set.add(cum);
//        }
//        return max;
//    }
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
