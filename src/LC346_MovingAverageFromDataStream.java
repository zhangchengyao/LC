import java.util.LinkedList;
import java.util.Queue;

public class LC346_MovingAverageFromDataStream {
    Queue<Integer> q;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public LC346_MovingAverageFromDataStream(int size) {
        q = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if(q.size()<size){
            q.offer(val);
            sum += val;
        }
        else{
            sum += val-q.poll();
            q.offer(val);
        }
        return sum/(double)q.size();
    }
}
