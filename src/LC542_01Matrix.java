import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC542_01Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return matrix;

        int[][] dist = new int[matrix.length][matrix[0].length];

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c<matrix[0].length; c++){
                if(matrix[r][c] != 0){
                    dist[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] != 0){
                    if(r > 0 && dist[r-1][c] != Integer.MAX_VALUE) dist[r][c] = Math.min(dist[r][c], 1 + dist[r-1][c]);
                    if(c > 0 && dist[r][c-1] != Integer.MAX_VALUE) dist[r][c] = Math.min(dist[r][c], 1 + dist[r][c-1]);
                }
            }
        }

        for(int r = matrix.length - 1; r >= 0; r--){
            for(int c = matrix[0].length - 1; c >= 0; c--){
                if(matrix[r][c] != 0){
                    if(r < matrix.length - 1 && dist[r+1][c] != Integer.MAX_VALUE) dist[r][c] = Math.min(dist[r][c], 1 + dist[r+1][c]);
                    if(c < matrix[0].length - 1 && dist[r][c+1] != Integer.MAX_VALUE) dist[r][c] = Math.min(dist[r][c], 1 + dist[r][c+1]);
                }
            }
        }

        return dist;
    }


//    public int[][] updateMatrix(int[][] matrix) {
//        if(matrix==null || matrix.length==0) return matrix;
//
//        int[][] dist = new int[matrix.length][matrix[0].length];
//
//        for(int r = 0;r < matrix.length; r++){
//            for(int c = 0; c<matrix[0].length; c++){
//                if(matrix[r][c] != 0){
//                    dist[r][c] = bfs(matrix, r, c);
//                }
//            }
//        }
//
//        return dist;
//    }
//
//    private int bfs(int[][] matrix, int r, int c){
//        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//
//        Queue<String> q = new LinkedList<>();
//        HashSet<String> visited = new HashSet<>();
//
//        String state = r + " " + c;
//        q.offer(state);
//        visited.add(state);
//        int level = 0;
//
//        while(!q.isEmpty()){
//            int cnt = q.size();
//            for(int i = 0; i < cnt; i++){
//                String[] pos = q.poll().split(" ");
//                r = Integer.parseInt(pos[0]);
//                c = Integer.parseInt(pos[1]);
//                if(matrix[r][c] == 0) return level;
//                for(int[] dire: directions){
//                    int newR = r + dire[0];
//                    int newC = c + dire[1];
//                    state = newR + " " + newC;
//                    if(isValid(newR, newC, matrix) && !visited.contains(state)){
//                        q.offer(state);
//                    }
//                }
//            }
//            level++;
//        }
//        return level;
//    }
//
//    private boolean isValid(int r, int c, int[][] matrix){
//        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length;
//    }
}
