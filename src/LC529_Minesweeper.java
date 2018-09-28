public class LC529_Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if(board[row][col]=='M') board[row][col] = 'X';
        else{
            reveal(board, row, col);
        }
        return board;
    }
    private void reveal(char[][] board, int row, int col){
        int mines = 0;
        for(int i=Math.max(0, row-1);i<=Math.min(board.length-1,row+1);i++){
            for(int j=Math.max(0, col-1);j<=Math.min(board[0].length-1,col+1);j++){
                if(i==row && j==col) continue;
                if(board[i][j]=='M') mines++;
            }
        }
        if(mines==0){
            board[row][col] = 'B';
            // reveal recursively
            for(int i=Math.max(0, row-1);i<=Math.min(board.length-1,row+1);i++){
                for(int j=Math.max(0, col-1);j<=Math.min(board[0].length-1,col+1);j++){
                    if(i==row && j==col) continue;
                    if(board[i][j]=='E') reveal(board, i, j);
                }
            }
        }else{
            board[row][col] = (char)('0'+mines);
        }
    }
}
