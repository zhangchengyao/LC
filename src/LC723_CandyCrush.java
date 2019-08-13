public class LC723_CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean stable = false;
        while(!stable) {
            stable = true;

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    // check row
                    int t = j + 1;
                    while(t < n && Math.abs(board[i][t]) == Math.abs(board[i][j])) t++;
                    if(t - j >= 3) {
                        for(int k = t - 1; k >= j; k--) {
                            if(board[i][k] > 0) board[i][k] = -board[i][k];
                        }
                    }
                    // check column
                    t = i + 1;
                    while(t < m && Math.abs(board[t][j]) == Math.abs(board[i][j])) t++;
                    if(t - i >= 3) {
                        for(int k = t - 1; k >= i; k--) {
                            if(board[k][j] > 0) board[k][j] = -board[k][j];
                        }
                    }
                }
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] < 0) {
                        stable = false;
                        board[i][j] = 0;
                    }
                }
            }

            for(int j = 0; j < n; j++) {
                int i = m - 1;
                while(i >= 0 && board[i][j] > 0) i--;
                if(i > 0) {
                    int t = i - 1;
                    while(t >= 0) {
                        if(board[t][j] > 0) {
                            board[i--][j] = board[t][j];
                            board[t][j] = 0;
                        }
                        t--;
                    }
                }
            }
        }

        return board;
    }
}
