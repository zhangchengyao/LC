import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC773_SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int startX = 0;
        int startY = 0;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==0){
                    startX = i;
                    startY = j;
                }
            }
        }
        String state = getState(board);
        q.offer(state);
        visited.add(state);
        int cnt = 1;
        int res = 0;
        while(!q.isEmpty()){
            for(int t=0;t<cnt;t++){
                String cur = q.poll();
                if(cur.equals("123450")) return res;
                int x = 0;
                int y = 0;
                for(int i=0;i<2;i++){
                    for(int j=0;j<3;j++){
                        board[i][j] = cur.charAt(i*3+j)-'0';
                        if(board[i][j]==0){
                            x = i;
                            y = j;
                        }
                    }
                }
                if(x>0){
                    board[x][y] = board[x-1][y];
                    board[x-1][y] = 0;
                    state = getState(board);
                    if(!visited.contains(state)){
                        q.offer(state);
                        visited.add(state);
                    }
                    board[x-1][y] = board[x][y];
                    board[x][y] = 0;
                }
                if(x<1){
                    board[x][y] = board[x+1][y];
                    board[x+1][y] = 0;
                    state = getState(board);
                    if(!visited.contains(state)){
                        q.offer(state);
                        visited.add(state);
                    }
                    board[x+1][y] = board[x][y];
                    board[x][y] = 0;
                }
                if(y>0){
                    board[x][y] = board[x][y-1];
                    board[x][y-1] = 0;
                    state = getState(board);
                    if(!visited.contains(state)){
                        q.offer(state);
                        visited.add(state);
                    }
                    board[x][y-1] = board[x][y];
                    board[x][y] = 0;
                }
                if(y<2){
                    board[x][y] = board[x][y+1];
                    board[x][y+1] = 0;
                    state = getState(board);
                    if(!visited.contains(state)){
                        q.offer(state);
                        visited.add(state);
                    }
                    board[x][y+1] = board[x][y];
                    board[x][y] = 0;
                }
            }
            cnt = q.size();
            res++;
        }
        return -1;
    }
    private String getState(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++) sb.append(board[i][j]);
        }
        return sb.toString();
    }
}
