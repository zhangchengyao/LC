import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC490_TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String cur = start[0]+" "+start[1];
        q.offer(cur);
        seen.add(cur);
        while(!q.isEmpty()){
            cur = q.poll();
            int[] coord = getCoord(cur);
            if(coord[0]==destination[0]&&coord[1]==destination[1]) return true;
            if(coord[0]>0 && maze[coord[0]-1][coord[1]]==0){
                String next = getNextState(maze, coord[0], coord[1], 'U');
                if(!seen.contains(next)){
                    seen.add(next);
                    q.offer(next);
                }
            }
            if(coord[0]<maze.length-1 && maze[coord[0]+1][coord[1]]==0){
                String next = getNextState(maze, coord[0], coord[1], 'D');
                if(!seen.contains(next)){
                    seen.add(next);
                    q.offer(next);
                }
            }
            if(coord[1]<maze[0].length-1 && maze[coord[0]][coord[1]+1]==0){
                String next = getNextState(maze, coord[0], coord[1], 'R');
                if(!seen.contains(next)){
                    seen.add(next);
                    q.offer(next);
                }
            }
            if(coord[1]>0 && maze[coord[0]][coord[1]-1]==0){
                String next = getNextState(maze, coord[0], coord[1], 'L');
                if(!seen.contains(next)){
                    seen.add(next);
                    q.offer(next);
                }
            }
        }
        return false;
    }
    private int[] getCoord(String s){
        String[] str = s.split(" ");
        return new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
    }
    private String getNextState(int[][] maze, int x, int y, char direct){
        if(direct=='U'){
            while(x>=0 && maze[x][y]==0) x--;
            return (x+1)+" "+y;
        }else if(direct=='D'){
            while(x<maze.length && maze[x][y]==0) x++;
            return (x-1)+" "+y;
        }else if(direct=='R'){
            while(y<maze[0].length && maze[x][y]==0) y++;
            return x+" "+(y-1);
        }else{
            while(y>=0 && maze[x][y]==0) y--;
            return x+" "+(y+1);
        }
    }
}
