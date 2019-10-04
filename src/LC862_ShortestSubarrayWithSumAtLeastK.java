import java.util.Deque;
import java.util.LinkedList;

public class LC862_ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        long[] sum = new long[n + 1];
        for(int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + A[i];
        }

        int len = n + 1;
        Deque<Integer> dq = new LinkedList<>();

        for(int y = 0; y <= n; y++) {
            while(!dq.isEmpty() && sum[y] <= sum[dq.getLast()]) dq.removeLast();
            while(!dq.isEmpty() && sum[y] - sum[dq.getFirst()] >= K) len = Math.min(len, y - dq.removeFirst());

            dq.addLast(y);
        }

        return len == n + 1 ? -1 : len;
    }
}
