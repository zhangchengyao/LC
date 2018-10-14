import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC218_TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if(buildings==null || buildings.length==0) return res;
        for(int[] building: buildings){
            res.add(new int[]{building[0], 0});
            res.add(new int[]{building[1], 0});
        }
        Collections.sort(res, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        for(int[] point: res){
            for(int[] building: buildings){
                if(building[0]>point[0]) break;
                if(point[0] < building[1]) point[1] = Math.max(point[1], building[2]);
            }
        }
        for(int i=1;i<res.size();i++){
            if(res.get(i)[1]==res.get(i-1)[1]){
                res.remove(i);
                i--;
            }
        }
        return res;
    }
}
