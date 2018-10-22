import java.util.HashMap;

public class LC447_NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<points.length;i++){
            map.clear();
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                int dist = (int)Math.pow(points[i][0]-points[j][0], 2)+(int)Math.pow(points[i][1]-points[j][1], 2);
                map.put(dist, map.getOrDefault(dist, 0)+1);
            }
            for(int key: map.keySet()){
                if(map.get(key)>=2) res += map.get(key)*(map.get(key)-1);
            }
        }
        return res;
    }
}
