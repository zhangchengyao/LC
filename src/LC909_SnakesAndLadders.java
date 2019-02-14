import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC909_SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int move = 0;
        while(!q.isEmpty()){
            int cnt = q.size();
            for(int k = 0; k < cnt; k++){
                int cur = q.poll();
                if(cur == n * n - 1) return move;
                for(int i = 1; i <= 6; i++){
                    int next = cur + i;
                    if(next > n * n - 1) break;

                    int[] coord = convert(n, next);
                    if(board[coord[0]][coord[1]] != -1){
                        next = board[coord[0]][coord[1]] - 1;
                    }

                    if(!visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }

            move++;
        }

        return -1;
    }

    private int[] convert(int n, int pos){
        int r = n - 1 - pos / n;
        int offset = pos % n;
        int c = ((n - 1 - r) & 1) == 0 ? offset : n - 1 - offset;

        return new int[]{r, c};
    }
}
