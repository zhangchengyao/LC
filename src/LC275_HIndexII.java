public class LC275_HIndexII {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        int h = 0;
        int l = 0;
        int r = citations.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(citations[mid]>=citations.length-mid){
                h = Math.max(h, citations.length-mid);
                r = mid-1;
            }else{
                h = Math.max(h, citations[mid]);
                l = mid+1;
            }
        }
        return h;
    }
}
