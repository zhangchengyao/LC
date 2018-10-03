import java.util.Arrays;
import java.util.Comparator;

public class LC452_MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return Integer.compare(p1[0], p2[0]);
            }
        });
        int res = 1;
        int l = points[0][0];
        int r = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=r){
                l = Math.max(l, points[i][0]);
                r = Math.min(r, points[i][1]);
            }
            else{
                l = points[i][0];
                r = points[i][1];
                res++;
            }
        }
        return res;
    }
}
