import java.util.PriorityQueue;

public class LC407_TrappingRainWaterII {
    class Block{
        int x;
        int y;
        int h;
        Block(int _x, int _y, int _h){
            x = _x;
            y = _y;
            h = _h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null || heightMap.length==0) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Block> pq = new PriorityQueue<>((a, b) -> a.h-b.h);
        boolean[][] visited = new boolean[m][n];
        int[] dirX = new int[]{1, -1, 0, 0};
        int[] dirY = new int[]{0, 0, 1, -1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Block b = new Block(i, j, heightMap[i][j]);
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    pq.offer(b);
                    visited[i][j] = true;
                }
            }
        }
        int mx = 0;
        int res = 0;
        while(!pq.isEmpty()){
            Block cur = pq.poll();
            mx = Math.max(mx, cur.h);
            for(int i=0;i<dirX.length;i++){
                int x = cur.x+dirX[i];
                int y = cur.y+dirY[i];
                if(x<0 || x>=m || y<0 || y>=n || visited[x][y]) continue;
                visited[x][y] = true;
                pq.offer(new Block(x, y, heightMap[x][y]));
                if(heightMap[x][y]<mx) res += mx-heightMap[x][y];
            }
        }
        return res;
    }
}
