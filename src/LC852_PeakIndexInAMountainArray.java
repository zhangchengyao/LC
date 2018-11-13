public class LC852_PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        for(;i<A.length;i++){
            if(A[i]>A[i+1]) break;
        }
        return i;
    }
}
