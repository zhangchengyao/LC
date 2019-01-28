package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class Remove_Obstacle {
    public static int removeObstacle(int numRows, int numColumns, int[][] lot){
        if(lot[0][0]==9) return 0;

        int[][] direction = {{-1,0}, {1, 0}, {0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        lot[0][0] = 0;
        int level = 0;
        while(!q.isEmpty()){
            int cnt = q.size();
            for(int i=0;i<cnt;i++){
                int[] pos = q.poll();
                for(int d=0;d<direction.length;d++){
                    int newR = pos[0] + direction[d][0];
                    int newC = pos[1] + direction[d][1];
                    if(valid(newR, newC, lot) && lot[newR][newC]!=0){
                        if(lot[newR][newC]==9) return level+1;
                        lot[newR][newC] = 0;
                        q.offer(new int[]{newR, newC});
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private static boolean valid(int r, int c, int[][] lot){
        return r>=0 && r<lot.length && c>=0 && c<lot[0].length;
    }

    public static void main(String[] args){
        int[][] lot = {
                    {1,1,1,1},
                    {0,1,1,1},
                    {0,1,0,1},
                    {1,1,9,1},
                    {0,0,1,1}};
        System.out.println(removeObstacle(5,4,lot));
    }
}
