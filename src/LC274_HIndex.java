import java.util.Arrays;

public class LC274_HIndex {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        Arrays.sort(citations);
        int h = Math.min(citations.length, citations[citations.length-1]);
        int i = citations.length-1;
        for(;h>=0;h--){
            while(i>=0 && citations[i]>=h) i--;
            if(i<0) break;
            if(citations.length-1-i>=h) break;
        }
        return Math.max(h, 0);
    }
}
