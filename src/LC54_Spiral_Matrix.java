import java.util.ArrayList;
import java.util.List;

public class LC54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        int i = 0;
        int j = 0;
        while(true){
            if((i==0 || visited[i-1][j]==1)
                    && (i==m-1 || visited[i+1][j]==1)
                    && (j==0 || visited[i][j-1]==1)
                    && (j==n-1 || visited[i][j+1]==1)){
                if(visited[i][j]==0) res.add(matrix[i][j]);
                break;
            }
            // at the upper left corner
            if((i==0 || visited[i-1][j]==1) && (j==0 || visited[i][j-1]==1) && j!=n-1 && visited[i][j+1]==0){
                if(visited[i][j]==0){
                    visited[i][j] = 1;
                    res.add(matrix[i][j]);
                }
                // go right
                while(!(j==n-1 || visited[i][j+1]==1)){
                    j++;
                    visited[i][j] = 1;
                    res.add(matrix[i][j]);
                }
            }
            // at the upper right corner
            else if((i==0 || visited[i-1][j]==1) && (j==n-1 || visited[i][j+1]==1) && i!=m-1 && visited[i+1][j]==0){
                if(visited[i][j]==0){
                    visited[i][j] = 1;
                    res.add(matrix[i][j]);
                }
                // go down
                while(!(i==m-1 || visited[i+1][j]==1)){
                    i++;
                    visited[i][j] = 1;
                    res.add(matrix[i][j]);
                }
            }
            // at the lower right corner
            else if((i==m-1 || visited[i+1][j]==1) && (j==n-1 || visited[i][j+1]==1) && j!=0 && visited[i][j-1]==0){
                if(visited[i][j]==0){
                    visited[i][j] = 1;
                    res.add(matrix[i][j]);
                }
                // go left
                while(!(j==0 || visited[i][j-1]==1)){
                    j--;
                    visited[i][j] = 1;
                    res.add(matrix[i][j]);
                }
            }
            // at the lower left corner
            else{
                if(visited[i][j]==0){
                    visited[i][j] = 1;
                    res.add(matrix[i][j]);
                }
                // go up
                while(!(i==0 || visited[i-1][j]==1)){
                    i--;
                    visited[i][j] = 1;
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
