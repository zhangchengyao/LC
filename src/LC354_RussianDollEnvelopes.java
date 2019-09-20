import java.util.Arrays;

public class LC354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] heights = new int[envelopes.length];
        int res = 0;
        for(int[] envelope: envelopes) {
            int idx = Arrays.binarySearch(heights, 0, res, envelope[1]);
            if(idx < 0) idx = -idx - 1;
            heights[idx] = envelope[1];
            if(idx == res) res++;
        }

        return res;
    }
}
