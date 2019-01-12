import java.util.Arrays;

public class LC174_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] hp = new int[m][n];

        for(int[] row: hp) Arrays.fill(row, Integer.MAX_VALUE);
        hp[m-1][n-1] = dungeon[m-1][n-1]>=0?1:-dungeon[m-1][n-1]+1;

        for(int r=m-1;r>=0;r--){
            for(int c=n-1;c>=0;c--){
                if(r==m-1 && c==n-1) continue;

                int goRight = c==n-1?Integer.MAX_VALUE:hp[r][c+1];
                int goDown = r==m-1?Integer.MAX_VALUE:hp[r+1][c];
                int min = Math.min(goRight, goDown);
                hp[r][c] = Math.max(1, min-dungeon[r][c]);
            }
        }

        return hp[0][0];
    }
}
