import java.util.LinkedList;
import java.util.Queue;

public class LC346_MovingAverageFromDataStream {

    private Queue<Integer> q;
    private double sum;
    private int size;

    /** Initialize your data structure here. */
    public LC346_MovingAverageFromDataStream(int size) {
        q = new LinkedList<>();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if(q.size() == size) {
            sum -= q.poll();
        }
        sum += val;
        q.offer(val);
        return sum / q.size();
    }
}
