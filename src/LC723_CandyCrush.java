public class LC723_CandyCrush {
    public int[][] candyCrush(int[][] board) {
        boolean stable = false;
        while(!stable){
            stable = true;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==0 || (i>0 && Math.abs(board[i][j])==Math.abs(board[i-1][j]))) continue;
                    int r = i+1;
                    while(r<board.length && Math.abs(board[r][j])==Math.abs(board[i][j])) r++;
                    for(int k=i;k<r;k++){
                        if(probeRow(board, k, j)) stable = false;
                        if(r-i>=3){
                            stable = false;
                            if(board[k][j]>0) board[k][j] = -board[k][j];
                        }
                    }
                }
            }
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]<0) board[i][j]=0;
                }
            }

            update(board);
        }
        return board;
    }
    private boolean probeRow(int[][] board, int i, int j){
        int cnt = 1;
        int k = j-1;
        while(k>=0 && Math.abs(board[i][k])==Math.abs(board[i][j])){
            cnt++;
            k--;
        }
        int t = j+1;
        while(t<board[0].length && Math.abs(board[i][t])==Math.abs(board[i][j])){
            cnt++;
            t++;
        }
        if(cnt>=3){
            for(int y=k+1;y<t;y++){
                if(board[i][y]>0) board[i][y] = -board[i][y];
            }
            return true;
        }
        return false;
    }
    private void update(int[][] board){
        for(int c=0;c<board[0].length;c++){
            int bottom = board.length-1;
            while(bottom>=0 && board[bottom][c]!=0) bottom--;
            while(bottom>=0){
                int start = bottom-1;
                while(start>=0 && board[start][c]==0) start--;
                if(start<0) break;
                int top = start-1;
                while(top>=0 && board[top][c]!=0) top--;
                for(int i=0;i<start-top;i++){
                    board[bottom-i][c] = board[start-i][c];
                }
                for(int i=bottom-(start-top);i>top;i--){
                    board[i][c] = 0;
                }
                bottom = bottom-(start-top);
            }
        }
    }
}
