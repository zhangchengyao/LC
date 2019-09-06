public class LC1064_FixedPoint {
    public int fixedPoint(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(A[mid] >= mid) right = mid - 1;
            else left = mid + 1;
        }

        return left < A.length && A[left] == left ? left : -1;
    }
}
