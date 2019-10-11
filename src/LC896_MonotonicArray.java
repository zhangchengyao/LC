public class LC896_MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if(A.length == 1) return true;

        Boolean inc = null;
        for(int i = 1; i < A.length; i++) {
            if(A[i] != A[i - 1]) {
                if(inc == null) inc = A[i] > A[i - 1];
                else {
                    if((inc && A[i] < A[i - 1]) || (!inc && A[i] > A[i - 1])) return false;
                }
            }
        }

        return true;
    }
}
