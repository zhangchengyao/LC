import java.util.Arrays;

public class LC853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0]-a[0]);
        int res = 0;
        for(int i=0;i<cars.length;i++){
            int p = i+1;
            while(p<cars.length && cars[p][1]>cars[i][1] && (target-cars[i][0])*1.0/cars[i][1]>=(target-cars[p][0])*1.0/cars[p][1]) p++;
            res++;
            i = p-1;
        }
        return res;
    }
}
