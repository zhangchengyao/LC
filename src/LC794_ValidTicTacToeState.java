public class LC794_ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int size = board.length;
        int xCnt = 0;
        int oCnt = 0;
        boolean xWin = false;
        boolean oWin = false;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i].charAt(j) == 'X') {
                    xCnt++;
                    if(j == 0 && board[i].charAt(j + 1) == 'X' && board[i].charAt(j + 2) == 'X') xWin = true;
                    if(i == 0 && board[i + 1].charAt(j) == 'X' && board[i + 2].charAt(j) == 'X') xWin = true;
                    if(i == 0 && j == 0 && board[i + 1].charAt(j + 1) == 'X' && board[i + 2].charAt(j + 2) == 'X') xWin = true;
                    if(i == 0 && j == size - 1 && board[i + 1].charAt(j - 1) == 'X' && board[i + 2].charAt(j - 2) == 'X')   xWin = true;
                } else if(board[i].charAt(j) == 'O') {
                    oCnt++;
                    if(j == 0 && board[i].charAt(j + 1) == 'O' && board[i].charAt(j + 2) == 'O') oWin = true;
                    if(i == 0 && board[i + 1].charAt(j) == 'O' && board[i + 2].charAt(j) == 'O') oWin = true;
                    if(i == 0 && j == 0 && board[i + 1].charAt(j + 1) == 'O' && board[i + 2].charAt(j + 2) == 'O') oWin = true;
                    if(i == 0 && j == size - 1 && board[i + 1].charAt(j - 1) == 'O' && board[i + 2].charAt(j - 2) == 'O') oWin = true;
                }
            }

        }

        return xWin ? xCnt == oCnt + 1 && !oWin : (oWin ? xCnt == oCnt : xCnt == oCnt + 1 || xCnt == oCnt);
    }
}
