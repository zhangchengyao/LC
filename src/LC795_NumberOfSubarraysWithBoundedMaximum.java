public class LC795_NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayMaxSmaller(A, R) - numSubarrayMaxSmaller(A, L - 1);
    }

    private int numSubarrayMaxSmaller(int[] A, int R) {
        int cnt = 0;
        int i = 0;
        int curMax = 0;
        for(int j = 0; j < A.length; j++) {
            curMax = Math.max(curMax, A[j]);
            if(curMax <= R) cnt += j - i + 1;
            else {
                curMax = 0;
                i = j + 1;
            }
        }

        return cnt;
    }
}
