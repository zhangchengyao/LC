import java.util.Arrays;

public class LC475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int minR = 0;
        int idx = 0;
        for(int i=0;i<houses.length;i++){
            idx = Arrays.binarySearch(heaters, houses[i]);
            if(idx<0) idx = -idx-1;
            if(idx==heaters.length){
                minR = Math.max(minR, houses[houses.length-1]-heaters[idx-1]);
                break;
            }
            else {
                if(idx==0) minR = Math.max(minR, heaters[idx]-houses[i]);
                else minR = Math.max(minR, Math.min(heaters[idx]-houses[i], houses[i]-heaters[idx-1]) );
            }
        }

        return minR;
    }
}
