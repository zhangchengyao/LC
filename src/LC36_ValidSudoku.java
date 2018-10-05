public class LC36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(row[i][board[i][j]-'1']) return false;
                row[i][board[i][j]-'1'] = true;
                if(col[j][board[i][j]-'1']) return false;
                col[j][board[i][j]-'1'] = true;
                if(box[i/3*3+j/3][board[i][j]-'1']) return false;
                box[i/3*3+j/3][board[i][j]-'1'] = true;
            }
        }
        return true;
    }
}
