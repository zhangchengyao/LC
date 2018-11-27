import java.util.Random;

public class LC497_RandomPointInNonoverlappingRectangles {
    private int[][] rects;
    private int[] areas;
    public LC497_RandomPointInNonoverlappingRectangles(int[][] rects) {
        this.rects = rects;
        areas = new int[rects.length];
        for(int i=0;i<rects.length;i++){
            int area = (rects[i][2] - rects[i][0] + 1)*(rects[i][3] - rects[i][1] + 1);
            if(i==0) areas[0] = area;
            else areas[i] = areas[i-1]+area;
        }
    }

    public int[] pick() {
        Random rand = new Random();
        int area = rand.nextInt(areas[areas.length-1])+1;
        int l = 0;
        int r = areas.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(areas[mid]<area) l = mid+1;
            else r = mid-1;
        }
        int[] rect = rects[l];
        int x = rand.nextInt(rect[2]-rect[0]+1);
        int y = rand.nextInt(rect[3]-rect[1]+1);
        return new int[]{rect[0]+x, rect[1]+y};
    }
}
