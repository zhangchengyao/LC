import java.util.Arrays;

public class LC757_SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        // Greedy algorithm
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int size = 0;
        int l2 = -1;
        int l1 = -1;
        for(int[] interval: intervals) {
            if(l1 < interval[0]) {
                l2 = interval[1] - 1;
                l1 = interval[1];
                size += 2;
            } else if(l2 < interval[0]) {
                l2 = l1;
                l1 = interval[1];
                size++;
            }
        }

        return size;
    }
}
