public class LC845_LongestMountainInArray {
    public int longestMountain(int[] A) {
        int longest = 0;
        int start = 0;
        while(start < A.length - 1) {
            if(A[start] < A[start + 1]) {
                int peak = start + 1;
                while(peak < A.length && A[peak] > A[peak - 1]) peak++;

                if(peak == A.length) break;
                if(A[peak] == A[peak - 1]) {
                    start = peak;
                    continue;
                }

                int end = peak;
                while(end < A.length && A[end] < A[end - 1]) end++;

                longest = Math.max(longest, end - start);
                start = end - 2;
            }
            start++;
        }

        return longest;
    }
}
