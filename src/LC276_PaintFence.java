public class LC276_PaintFence {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        if(n == 2) return k * k;

        int same = k;
        int diff = k * (k - 1);

        for(int i = 3; i <= n; i++) {
            int preSame = same;
            int preDiff = diff;

            same = preDiff;
            diff = (preSame + preDiff) * (k - 1);
        }

        return same + diff;
    }
}
