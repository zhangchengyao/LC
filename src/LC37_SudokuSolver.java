public class LC37_SudokuSolver {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] box = new boolean[9][9];
    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                row[i][board[i][j]-'1'] = true;
                col[j][board[i][j]-'1'] = true;
                box[i/3*3+j/3][board[i][j]-'1'] = true;
            }
        }
        solve(board, 0);
    }
    private boolean solve(char[][] board, int num){
        if(num==81) return true;
        int i = num/9;
        int j = num%9;
        while(num<81 && board[i][j]!='.'){
            num++;
            i = num/9;
            j = num%9;
        }
        if(num==81) return true;
        for(int d=1;d<=9;d++){
            if(!row[i][d-1] && !col[j][d-1] && !box[i/3*3+j/3][d-1]){
                board[i][j] = (char)(d+'0');
                row[i][d-1] = true;
                col[j][d-1] = true;
                box[i/3*3+j/3][d-1] = true;
                if(solve(board, num+1)) return true;
                board[i][j] = '.';
                row[i][d-1] = false;
                col[j][d-1] = false;
                box[i/3*3+j/3][d-1] = false;
            }
        }
        return false;
    }
}
