public class LC849_MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int i = 0;
        while(i<seats.length && seats[i]==0) i++;
        int maxLen = i;
        int j = seats.length-1;
        while(j>=0 && seats[j]==0) j--;
        if(seats.length-1-j>maxLen){
            maxLen = seats.length-1-j;
        }
        int curLen = 0;
        while(i<=j){
            if(seats[i]==1){
                if((curLen+1)/2>maxLen){
                    maxLen = (curLen+1)/2;
                }
                curLen = 0;
            }
            else curLen++;
            i++;
        }
        return maxLen;
    }
}
