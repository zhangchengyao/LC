public class LC774_MinimizeMaxDistanceToGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        double left = 0;
        double right = Integer.MAX_VALUE;
        while(right - left > 1e-6) {
            double mid = left + (right - left) / 2;
            if(check(stations, K, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left;
    }

    private boolean check(int[] stations, int K, double dist) {
        int cnt = 0;
        for(int i = 0; i < stations.length - 1; i++) {
            cnt += Math.ceil((stations[i + 1] - stations[i]) / dist - 1);
        }


        return cnt <= K;
    }
}
