public class LC130_SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return ;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, visited, i, j);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(visited[i][j] || board[i][j] != 'O') return;
        visited[i][j] = true;
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i + 1, j);
        dfs(board, visited, i, j - 1);
        dfs(board, visited, i, j + 1);
    }
}
