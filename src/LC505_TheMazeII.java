import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC505_TheMazeII {
    class State{
        int x;
        int y;
        int dist;
        State(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this. dist = dist;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        HashSet<String> seen = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>(); // state => dist
        Queue<State> q = new LinkedList<>();
        State cur = new State(start[0], start[1], 0);
        q.offer(cur);
        seen.add(start[0]+" "+start[1]);
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curDist = cur.dist;
            if(curX==destination[0]&&curY==destination[1])
                min = Math.min(min, curDist);
            if(curX>0 && maze[curX-1][curY]==0){
                State next = getNextState(maze, cur, 'U');
                String str = next.x+" "+next.y;
                if(!seen.contains(str)){
                    seen.add(str);
                    q.offer(next);
                    map.put(str, next.dist);
                }else if(map.containsKey(str) && map.get(str)>next.dist){
                    q.offer(next);
                    map.put(str, next.dist);
                }
            }
            if(curX<maze.length-1 && maze[curX+1][curY]==0){
                State next = getNextState(maze, cur, 'D');
                String str = next.x+" "+next.y;
                if(!seen.contains(str)){
                    seen.add(str);
                    q.offer(next);
                    map.put(str, next.dist);
                }else if(map.containsKey(str) && map.get(str)>next.dist){
                    q.offer(next);
                    map.put(str, next.dist);
                }
            }
            if(curY<maze[0].length-1 && maze[curX][curY+1]==0){
                State next = getNextState(maze, cur, 'R');
                String str = next.x+" "+next.y;
                if(!seen.contains(str)){
                    seen.add(str);
                    q.offer(next);
                    map.put(str, next.dist);
                }else if(map.containsKey(str) && map.get(str)>next.dist){
                    q.offer(next);
                    map.put(str, next.dist);
                }
            }
            if(curY>0 && maze[curX][curY-1]==0){
                State next = getNextState(maze, cur, 'L');
                String str = next.x+" "+next.y;
                if(!seen.contains(str)){
                    seen.add(str);
                    q.offer(next);
                    map.put(str, next.dist);
                }else if(map.containsKey(str) && map.get(str)>next.dist){
                    q.offer(next);
                    map.put(str, next.dist);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    private State getNextState(int[][] maze, State cur, char direct){
        if(direct=='U'){
            int tx = cur.x;
            while(tx>=0 && maze[tx][cur.y]==0) tx--;
            tx++;
            return new State(tx, cur.y, cur.dist+cur.x-tx);
        }else if(direct=='D'){
            int tx = cur.x;
            while(tx<maze.length && maze[tx][cur.y]==0) tx++;
            tx--;
            return new State(tx, cur.y, cur.dist+tx-cur.x);
        }else if(direct=='R'){
            int ty = cur.y;
            while(ty<maze[0].length && maze[cur.x][ty]==0) ty++;
            ty--;
            return new State(cur.x, ty, cur.dist+ty-cur.y);
        }else{
            int ty = cur.y;
            while(ty>=0 && maze[cur.x][ty]==0) ty--;
            ty++;
            return new State(cur.x, ty, cur.dist+cur.y-ty);
        }
    }
}
