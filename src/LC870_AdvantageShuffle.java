import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC870_AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        // pair[0] = index, pair[1] = B[index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < B.length; i++) pq.offer(new int[]{i, B[i]});

        int[] res = new int[A.length];
        int l = 0;
        int r = A.length - 1;
        for(int i = 0; i < A.length; i++) {
            int[] cur = pq.poll();
            if(cur[1] < A[r]) {
                res[cur[0]] = A[r--];
            } else {
                res[cur[0]] = A[l++];
            }
        }

        return res;
    }
}
