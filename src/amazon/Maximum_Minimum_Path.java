package amazon;

public class Maximum_Minimum_Path {
    public static int maxMinPath(int[][] matrix){
        if(matrix==null || matrix.length==0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                int fromUp = i>0?dp[i-1][j]:Integer.MIN_VALUE;
                int fromLeft = j>0?dp[i][j-1]:Integer.MIN_VALUE;
                dp[i][j] = Math.max(Math.min(fromUp, matrix[i][j]), Math.min(fromLeft, matrix[i][j]));
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args){
        int[][] matrix = {{8,4,7},{6,5,9}};
        System.out.println(maxMinPath(matrix));
    }
}
