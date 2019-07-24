public class LC348_DesignTicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag;
    private int antiDiag;
    /** Initialize your data structure here. */
    public LC348_DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int n = rows.length;
        if(player == 1){
            rows[row]++;
            cols[col]++;
            if(row == col) diag++;
            if(row + col == n-1) antiDiag++;
        }else{
            rows[row]--;
            cols[col]--;
            if(row == col) diag--;
            if(row + col == n-1) antiDiag--;
        }
        if(rows[row] == n || cols[col] == n || diag == n || antiDiag == n) return 1;
        else if(rows[row] == -n || cols[col] == -n || diag == -n || antiDiag == -n) return 2;
        else return 0;
    }
}
