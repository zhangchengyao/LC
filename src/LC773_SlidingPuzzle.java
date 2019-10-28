import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC773_SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String target = "123450";
        int m = board.length;
        int n = board[0].length;
        StringBuilder state = new StringBuilder();
        for (int[] row : board) {
            for (int j = 0; j < n; j++) {
                state.append(row[j]);
            }
        }
        if(state.toString().equals(target)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(state.toString());
        visited.add(state.toString());

        int move = 1;
        while(!q.isEmpty()) {
            int cnt = q.size();
            for(; cnt > 0; cnt--){
                state = new StringBuilder(q.poll());
                int idx = state.indexOf("0");
                int r = idx / n;
                int c = idx % n;
                for(int[] dir: directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n) continue;

                    String next = swap(state, idx, nextR * n + nextC);
                    if(next.equals(target)) return move;
                    if(!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                    swap(state, idx, nextR * n + nextC);
                }
            }
            move++;
        }

        return -1;
    }

    private String swap(StringBuilder sb, int a, int b) {
        char t = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, t);
        return sb.toString();
    }
}
