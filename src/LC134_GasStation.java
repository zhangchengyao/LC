public class LC134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int remain = 0;
        int pos = 0;
        for(int i=0;i<gas.length;i++){
            total += gas[i]-cost[i];
            remain += gas[i]-cost[i];
            if(remain<0){
                pos = i+1;
                remain = 0;
            }
        }
        if(total<0) return -1;
        else return pos;
        // int n = gas.length;
        // int res = -1;
        // for(int i=0;i<n;i++){
        //     if(gas[i]<cost[i]) continue;
        //     int cur = 0;
        //     int j = 0;
        //     for(;j<n;j++){
        //         cur += (gas[(i+j)%n]-cost[(i+j)%n]);
        //         if(cur<0) break;
        //     }
        //     if(j==n){
        //         res = i;
        //         break;
        //     }
        // }
        // return res;
    }
}
