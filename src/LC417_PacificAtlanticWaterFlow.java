import java.util.ArrayList;
import java.util.List;

public class LC417_PacificAtlanticWaterFlow {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix==null || matrix.length==0) return res;

        boolean[][] canReachPacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] canReachAtlantic = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            dfs(matrix, i, 0, canReachPacific);
            dfs(matrix, i, matrix[0].length-1, canReachAtlantic);
        }

        for(int j=0;j<matrix[0].length;j++){
            dfs(matrix, 0, j, canReachPacific);
            dfs(matrix, matrix.length-1, j, canReachAtlantic);
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(canReachPacific[i][j] && canReachAtlantic[i][j]) res.add(new int[]{i, j});
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, int r, int c, boolean[][] visited){
        if(!validPos(matrix, r, c) || visited[r][c]) return ;

        String pos = r + " " + c;
        visited[r][c] = true;
        for(int i=0;i<directions.length;i++){
            int deltaR = directions[i][0];
            int deltaC = directions[i][1];
            if(validPos(matrix, r+deltaR, c+deltaC) && matrix[r+deltaR][c+deltaC]>=matrix[r][c]){
                dfs(matrix, r+deltaR, c+deltaC, visited);
            }
        }
    }

    private boolean validPos(int[][] matrix, int r, int c){
        return r>=0 && r<matrix.length && c>=0 && c<matrix[0].length;
    }
}
