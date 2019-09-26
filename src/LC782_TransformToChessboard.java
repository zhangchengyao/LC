public class LC782_TransformToChessboard {
    // difficult to think of
    public int movesToChessboard(int[][] board) {
        int N = board.length;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) != 0) return -1;
            }
        }

        int rowSum = 0;
        int colSum = 0;
        int rowDiff = 0;
        int colDiff = 0;
        for(int i = 0; i < N; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if(board[0][i] != i % 2) rowDiff++;
            if(board[i][0] != i % 2) colDiff++;
        }

        if(rowSum > (N + 1) / 2 || rowSum < N / 2 || colSum > (N + 1) / 2 || colSum < N / 2) return -1;

        int swaps = 0;
        if((N & 1) == 1) {
            if((rowDiff & 1) == 1) swaps += N - rowDiff;
            else swaps += rowDiff;
            if((colDiff & 1) == 1) swaps += N - colDiff;
            else swaps += colDiff;
        } else {
            swaps += Math.min(rowDiff, N - rowDiff);
            swaps += Math.min(colDiff, N - colDiff);
        }

        return swaps / 2;
    }
}
