public class LC667_BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int l = 1;
        int r = n;
        int i = 0;
        for(; i < k - 1; i++) {
            res[i] = (i % 2 == 0 ? l++: r--);
        }
        if(i % 2 == 0) {
            while(l <= r) res[i++] = l++;
        } else {
            while(l <= r) res[i++] = r--;
        }
        return res;
    }
}
