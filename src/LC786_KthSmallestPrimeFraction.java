public class LC786_KthSmallestPrimeFraction {
    // difficult to think of
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double left = 0;
        double right = 1;
        int p;
        int q;
        while(true) {
            double mid = (left + right) / 2;
            int cnt = 0;
            p = 0;
            q = 1;
            for (int value : A) {
                int j = 1;
                while (j < A.length && value > mid * A[j]) j++;
                if (j == A.length) break;
                cnt += A.length - j;
                if (p * A[j] < q * value) {
                    p = value;
                    q = A[j];
                }
            }
            if(cnt > K) right = mid;
            else if(cnt == K) break;
            else left = mid;
        }

        return new int[]{p ,q};
    }
}
