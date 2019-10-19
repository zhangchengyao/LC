public class LC818_RaceCar {
    private int[] min = new int[10001];

    public int racecar(int target) {
        if(min[target] != 0) return min[target];

        int n = 1;
        while((1 << n) - 1 < target) {
            n++;
        }

        if((1 << n) - 1 == target) {
            min[target] = n;
        } else {
            min[target] = racecar((1 << n) - 1 - target) + n + 1;
            n--;
            int dist = target - ((1 << n) - 1);
            for(int m = 0; m < n; m++) {
                min[target] = Math.min(min[target], n + racecar(dist + ((1 << m) - 1)) + m + 2);
            }
        }
        return min[target];
    }
}
