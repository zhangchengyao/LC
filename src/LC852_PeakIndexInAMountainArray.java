public class LC852_PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
            else if(A[mid] > A[mid - 1]) left = mid + 1;
            else right = mid;
        }

        return left;
    }

//    public int peakIndexInMountainArray(int[] A) {
//        int i = 0;
//        for(; i < A.length; i++){
//            if(A[i] > A[i+1]) break;
//        }
//        return i;
//    }
}
