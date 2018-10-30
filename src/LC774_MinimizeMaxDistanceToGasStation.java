public class LC774_MinimizeMaxDistanceToGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        double[] intervals = new double[stations.length-1];
        for(int i=0;i<stations.length-1;i++){
            intervals[i] = stations[i+1]-stations[i];
        }
        double left = 0;
        double right = Integer.MAX_VALUE;
        double eps = 1e-7;
        while(Math.abs(right-left)>eps){
            double mid = left + (right-left)/2;
            if(check(intervals, mid, K)) right = mid;
            else left = mid;
        }
        return left;
    }
    private boolean check(double[] intervals, double gap, int K){
        int cnt = 0;
        for(double interval: intervals){
            cnt += (int)(interval/gap);
        }
        return cnt<=K;
    }
}
