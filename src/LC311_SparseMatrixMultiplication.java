import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC311_SparseMatrixMultiplication {
    // faster solution
//    public int[][] multiply(int[][] A, int[][] B) {
//        if(A.length == 0 || A[0].length == 0) return null;
//        int[][] res = new int[A.length][B[0].length];
//        for(int i = 0; i < A.length; i++){
//            for(int j = 0; j < A[0].length; j++){
//                if(A[i][j] == 0) continue;
//                for(int k = 0; k < B[0].length; k++){
//                    if(B[j][k] != 0) res[i][k] += A[i][j] * B[j][k];
//                }
//            }
//        }
//        return res;
//    }
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length == 0) return null;

        List<HashSet<Integer>> rows = new ArrayList<>();
        List<HashSet<Integer>> cols = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            rows.add(new HashSet<>());
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    rows.get(i).add(j);
                }
            }
        }

        for(int j = 0; j < B[0].length; j++) {
            cols.add(new HashSet<>());
            for(int i = 0; i < B.length; i++) {
                if(B[i][j] != 0) {
                    cols.get(j).add(i);
                }
            }
        }

        int[][] res = new int[A.length][B[0].length];
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                if(rows.get(i).size() < cols.get(j).size()) {
                    for(int idx: rows.get(i)) {
                        if(cols.get(j).contains(idx)) res[i][j] += A[i][idx] * B[idx][j];
                    }
                } else {
                    for(int idx: cols.get(j)) {
                        if(rows.get(i).contains(idx)) res[i][j] += A[i][idx] * B[idx][j];
                    }
                }
            }
        }

        return res;
    }
}
