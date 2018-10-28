public class LC818_RaceCar {
    int[] min = new int[10001];
    public int racecar(int target) {
        if(min[target]>0) return min[target];
        int n = (int)Math.floor(Math.log(target+1.0)/Math.log(2.0));
        if((1<<n)==target+1) min[target] = n;
        else{
            min[target] = n+2+racecar((1<<(n+1))-1-target);
            for(int i=0;i<n;i++){
                min[target] = Math.min(min[target], racecar(target-(1<<n)+(1<<i))+n+i+2);
            }
        }
        return min[target];
    }
}
