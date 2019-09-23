public class LC798_SmallestRotationWithHighestScore {
    // difficult to think of
    public int bestRotation(int[] A) {
        int n = A.length;
        int[] bad = new int[n + 1];
        for(int i = 0; i < A.length; i++) {
            int left = (i - A[i] + 1 + n) % n;
            int right = (i + 1) % n;
            bad[left]++;
            bad[right]--;
            if(left > right) bad[0]++;
        }

        int best = n;
        int res = 0;
        int cur = 0;
        for(int i = 0; i < n; i++) {
            cur += bad[i];
            if(cur < best) {
                best = cur;
                res = i;
            }
        }

        return res;
    }
}
