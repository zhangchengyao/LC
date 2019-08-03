import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC505_TheMazeII {
    class State {
        int r;
        int c;
        int dist;
        State(int _r, int _c, int _dist) {
            r = _r;
            c = _c;
            dist = _dist;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int destPos = destination[0] * n + destination[1];

        HashSet<Integer> visited = new HashSet<>();
        Queue<State> q = new LinkedList<>();
        HashMap<Integer, Integer> shortestForState = new HashMap<>();

        visited.add(start[0] * n + start[1]);
        q.offer(new State(start[0], start[1], 0));
        shortestForState.put(start[0] * n + start[1], 0);

        int shortest = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            State cur = q.poll();
            for(int[] dir: directions) {
                State nextState = getNextState(maze, cur, dir);
                int pos = cur.r * n + cur.c;
                int nextPos = nextState.r * n + nextState.c;
                if(nextPos != pos && (!visited.contains(nextPos) || shortestForState.get(nextPos) > nextState.dist)) {
                    if(nextPos == destPos) {
                        shortest = Math.min(shortest, nextState.dist);
                    } else {
                        q.offer(nextState);
                        visited.add(nextPos);
                        shortestForState.put(nextPos, nextState.dist);
                    }
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private State getNextState(int[][] maze, State cur, int[] dir) {
        int m = maze.length;
        int n = maze[0].length;
        State next = new State(cur.r, cur.c, cur.dist);
        while(valid(m, n, next.r, next.c) && maze[next.r][next.c] == 0) {
            next.r += dir[0];
            next.c += dir[1];
            next.dist ++;
        }
        next.r -= dir[0];
        next.c -= dir[1];
        next.dist--;

        return next;
    }

    private boolean valid(int m, int n, int curR, int curC) {
        return curR >= 0 && curR < m && curC >= 0 && curC < n;
    }
}
