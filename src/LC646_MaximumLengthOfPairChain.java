import java.util.Arrays;

public class LC646_MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) return 0;

        Arrays.sort(pairs, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int n = pairs.length;
        int len = 1;
        int[] prev = pairs[0];
        for(int i = 1; i < n; i++) {
            if(pairs[i][0] > prev[1]) {
                prev = pairs[i];
                len++;
            }
        }

        return len;
    }
}
