import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LC499_TheMazeIII {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dist = new int[maze.length][maze[0].length];
        for(int i=0;i<dist.length;i++)
            for(int j=0;j<dist[0].length;j++)
                dist[i][j] = Integer.MAX_VALUE;
        dist[ball[0]][ball[1]] = 0;
        HashMap<String, String> map = new HashMap<>(); // pos => moves
        int[] xMove = new int[]{-1, 1, 0, 0}; // up down left right
        int[] yMove = new int[]{0, 0, -1, 1};
        Queue<String> q = new LinkedList<>();
        String cur = ball[0]+" "+ball[1];
        q.offer(cur);
        while(!q.isEmpty()){
            cur = q.poll();
            int[] coord = getCoord(cur);
            for(int i=0;i<xMove.length;i++){
                int x = coord[0];
                int y = coord[1];
                String pos = coord[0]+" "+coord[1];
                while(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]!=1 && !(x==hole[0] && y==hole[1])){
                    x += xMove[i];
                    y += yMove[i];
                }
                if(x==hole[0] && y==hole[1]){
                    int d = dist[coord[0]][coord[1]] + Math.abs(x-coord[0])+Math.abs(y-coord[1]);
                    if(dist[x][y]>=d){
                        String move = "";
                        if(i==0) move = map.getOrDefault(pos, "")+'u';
                        else if(i==1) move = map.getOrDefault(pos, "")+'d';
                        else if(i==2) move = map.getOrDefault(pos, "")+'l';
                        else move = map.getOrDefault(pos, "")+'r';
                        if(dist[x][y]>d || (dist[x][y]==d&&map.get(x+" "+y).compareTo(move)>0)){
                            map.put(x+" "+y, move);
                            dist[x][y] = d;
                        }
                    }
                    continue;
                }
                else if(x==coord[0] && y==coord[1]) continue;
                else if(x==coord[0]) y -= yMove[i];
                else x -= xMove[i];
                int d = dist[coord[0]][coord[1]] + Math.abs(x-coord[0])+Math.abs(y-coord[1]);
                String move;
                if(i==0) move = map.getOrDefault(pos, "")+'u';
                else if(i==1) move = map.getOrDefault(pos, "")+'d';
                else if(i==2) move = map.getOrDefault(pos, "")+'l';
                else move = map.getOrDefault(pos, "")+'r';
                if(dist[x][y]>d || (dist[x][y]==d&&map.containsKey(x+" "+y)&&map.get(x+" "+y).compareTo(move)>0)){
                    q.offer(x+" "+y);
                    map.put(x+" "+y, move);
                    dist[x][y] = d;
                }
            }
        }
        return map.get(hole[0]+" "+hole[1])==null?"impossible":map.get(hole[0]+" "+hole[1]);
    }
    private int[] getCoord(String s){
        String[] str = s.split(" ");
        return new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
    }
}
