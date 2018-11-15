import java.util.HashMap;

public class LC835_ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        HashMap<String, Integer> count = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1){
                    for(int m=0;m<B.length;m++){
                        for(int n=0;n<B[0].length;n++){
                            if(B[m][n]==1){
                                String dist = (m-i)+" "+(n-j);
                                count.put(dist, count.getOrDefault(dist, 0)+1);
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int cnt: count.values()){
            res = Math.max(res, cnt);
        }
        return res;
    }
}
