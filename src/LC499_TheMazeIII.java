import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC499_TheMazeIII {
    class State {
        int r;
        int c;
        int dist;
        String path;
        State(int _r, int _c, int _dist, String _path) {
            r = _r;
            c = _c;
            dist = _dist;
            path = _path;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int holePos = hole[0] * n + hole[1];

        HashSet<Integer> visited = new HashSet<>();
        Queue<State> q = new LinkedList<>();
        HashMap<Integer, Integer> shortestForState = new HashMap<>();

        visited.add(ball[0] * n + ball[1]);
        q.offer(new State(ball[0], ball[1], 0, ""));
        shortestForState.put(ball[0] * n + ball[1], 0);

        int shortest = Integer.MAX_VALUE;
        String shortestPath = "z";
        while(!q.isEmpty()) {
            State cur = q.poll();
            for(int[] dir: directions) {
                State next = getNextState(maze, cur, dir, hole);
                int pos = cur.r * n + cur.c;
                int nextPos = next.r * n + next.c;
                if(pos != nextPos && (!visited.contains(nextPos) || shortestForState.get(nextPos) >= next.dist)) {
                    if(nextPos == holePos) {
                        if(next.dist < shortest) {
                            shortest = next.dist;
                            shortestPath = next.path;
                        } else if(next.dist == shortest) {
                            if(shortestPath.compareTo(next.path) > 0) {
                                shortestPath = next.path;
                            }
                        }
                    } else {
                        visited.add(nextPos);
                        q.offer(next);
                        shortestForState.put(nextPos, next.dist);
                    }
                }
            }
        }

        return shortestPath.equals("z") ? "impossible" : shortestPath;
    }

    private State getNextState(int[][] maze, State cur, int[] dir, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        State next = new State(cur.r, cur.c, cur.dist, cur.path);

        while(valid(m, n, next.r, next.c) && maze[next.r][next.c] == 0 && !(next.r == hole[0] && next.c == hole[1])) {
            next.r += dir[0];
            next.c += dir[1];
            next.dist ++;
        }
        if(!(next.r == hole[0] && next.c == hole[1])) {
            next.r -= dir[0];
            next.c -= dir[1];
            next.dist--;
        }

        if(dir[0] == 0 && dir[1] == 1) {
            next.path += 'r';
        } else if(dir[0] == 0 && dir[1] == -1) {
            next.path += 'l';
        } else if(dir[0] == -1 && dir[1] == 0) {
            next.path += 'u';
        } else {
            next.path += 'd';
        }

        return next;
    }

    private boolean valid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
