public class LC868_BinaryGap {
    public int binaryGap(int N) {
        int gap = 0;
        int prev = -1;
        int cur;

        while(N > 0) {
            int t = N & -N;

            if(prev == -1) prev = t;
            else {
                cur = t;
                gap = Math.max(gap, getDist(cur, prev));
                prev = cur;
            }
            N ^= t;
        }

        return gap;
    }

    private int getDist(int a, int b) {
        int c = a / b;
        int dist = 0;
        while(c > 1) {
            c >>= 1;
            dist++;
        }

        return dist;
    }
}
