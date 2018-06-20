public class LC289_GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board.length==0 || board[0].length==0) return;
        // dead -> live, set the cell 2
        // live -> dead, set the cell -1
        int rows = board.length;
        int columns = board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(board[i][j]==0) probeDead(board, i, j);
                else probeLive(board, i, j);
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(board[i][j]==-1) board[i][j] = 0;
                if(board[i][j]==2) board[i][j] = 1;
            }
        }
    }
    private void probeDead(int[][] board, int x, int y){
        if(countLive(board, x, y)==3) board[x][y] = 2;
    }
    private void probeLive(int[][] board, int x, int y){
        int live = countLive(board, x, y);
        if(live<2 || live>3) board[x][y] = -1;
    }
    private int countLive(int[][] board, int x, int y){
        int num_live = 0;
        if(x>0 && (board[x-1][y]==-1 || board[x-1][y]==1)) num_live++;
        if(x<board.length-1 && (board[x+1][y]==-1 || board[x+1][y]==1)) num_live++;
        if(y>0 && (board[x][y-1]==-1 || board[x][y-1]==1)) num_live++;
        if(y<board[0].length-1 && (board[x][y+1]==-1 || board[x][y+1]==1)) num_live++;
        if(x>0 && y>0 && (board[x-1][y-1]==-1 || board[x-1][y-1]==1)) num_live++;
        if(x>0 && y<board[0].length-1 && (board[x-1][y+1]==-1 || board[x-1][y+1]==1)) num_live++;
        if(x<board.length-1 && y>0 && (board[x+1][y-1]==-1 || board[x+1][y-1]==1)) num_live++;
        if(x<board.length-1 && y<board[0].length-1 && (board[x+1][y+1]==-1 || board[x+1][y+1]==1)) num_live++;
        return num_live;
    }
}
