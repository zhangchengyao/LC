public class LC562_LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        if(M==null || M.length==0) return 0;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1){
                    if(j==0||M[i][j-1]!=1){
                        // go horizontal
                        int k = j;
                        while(k<M[0].length && M[i][k]==1) k++;
                        res = Math.max(res, k-j);
                    }
                    if(i==0||M[i-1][j]!=1){
                        //go vertical
                        int k = i+1;
                        while(k<M.length && M[k][j]==1) k++;
                        res = Math.max(res, k-i);
                    }
                    if(i==0||j==0||M[i-1][j-1]!=1){
                        // go diagonal
                        int k = i+1;
                        int t = j+1;
                        while(k<M.length && t<M[0].length && M[k][t]==1){
                            k++;
                            t++;
                        }
                        res = Math.max(res, k-i);
                    }
                    if(i==0||j==M[0].length-1||M[i-1][j+1]!=1){
                        // go anti-diagonal
                        int k = i+1;
                        int t = j-1;
                        while(k<M.length && t>=0 && M[k][t]==1){
                            k++;
                            t--;
                        }
                        res = Math.max(res, k-i);
                    }
                }
            }
        }
        return res==Integer.MIN_VALUE?0:res;
    }
}
