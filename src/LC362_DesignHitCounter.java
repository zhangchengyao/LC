public class LC362_DesignHitCounter {
    int[] time;
    int[] hits;
    /** Initialize your data structure here. */
    public LC362_DesignHitCounter() {
        time = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp%300;
        if(time[index]==timestamp) hits[index]++;
        else{
            time[index] = timestamp;
            hits[index] = 1;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for(int i=0;i<300;i++){
            if(time[i]>timestamp-300) res += hits[i];
        }
        return res;
    }
}
