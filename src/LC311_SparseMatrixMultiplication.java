import java.util.HashMap;

public class LC311_SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        HashMap<Integer, Integer>[] arows = new HashMap[A.length];
        HashMap<Integer, Integer>[] bcols = new HashMap[B[0].length];
        for(int i=0;i<A.length;i++){
            arows[i] = new HashMap<>();
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]!=0) arows[i].put(j, A[i][j]);
            }
        }
        for(int i=0;i<B[0].length;i++){
            bcols[i] = new HashMap<>();
            for(int j=0;j<B.length;j++){
                if(B[j][i]!=0) bcols[i].put(j, B[j][i]);
            }
        }
        int[][] res = new int[A.length][B[0].length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                for(int key: arows[i].keySet()){
                    if(bcols[j].containsKey(key)) res[i][j] += arows[i].get(key)*bcols[j].get(key);
                }
            }
        }
        return res;
    }
}
