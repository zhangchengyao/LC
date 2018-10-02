public class LC498_DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0) return new int[]{};
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        boolean goUp = true;
        int x = 0;
        int y = 0;
        int i = 0 ;
        while(i<res.length){
            if(i==0) res[i++] = matrix[0][0];
            else{
                if(goUp){
                    if(y+1<n) y++;
                    else x++;
                    res[i++] = matrix[x][y];
                    goUp = false;
                    while(x<m-1 && y>0){
                        x++;
                        y--;
                        res[i++] = matrix[x][y];
                    }
                }
                else{
                    if(x+1<m) x++;
                    else y++;
                    res[i++] = matrix[x][y];
                    goUp = true;
                    while(x>0 && y<n-1){
                        x--;
                        y++;
                        res[i++] = matrix[x][y];
                    }
                }
            }
        }
        return res;
    }
}
