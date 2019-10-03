import java.util.Arrays;

public class LC853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0]-a[0]);

        int count = 0;
        for(int i = 0; i < cars.length; i++) {
            int j = i + 1;
            while(j < cars.length && (target - cars[i][0]) * 1.0 / cars[i][1] >= (target - cars[j][0]) * 1.0 / cars[j][1]) j++;
            count++;

            i = j - 1;
        }

        return count;
    }
}
