public class LC484_FindPermutation {
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] res = new int[len + 1];

        int cur = 1;
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == 'I') {
                res[i] = cur++;
            } else {
                int cnt = 1;
                while(i + cnt < len && s.charAt(i + cnt) == 'D') cnt++;
                cur += cnt;
                for(int k = 0; k <= cnt; k++) {
                    res[i + k] = cur - k;
                }
                i += cnt;
                cur++;
            }
        }

        if(res[len] == 0) res[len] = cur;
        return res;
    }
}
