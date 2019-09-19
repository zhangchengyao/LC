import java.util.LinkedList;
import java.util.Queue;

public class LC225_ImplementStackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public LC225_ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!q2.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!q1.isEmpty()) {
            while(q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else {
            while(q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int res = 0;
        if(!q1.isEmpty()) {
            while(q1.size() > 1) {
                q2.offer(q1.poll());
            }
            res = q1.poll();
            q2.offer(res);
        } else {
            while(q2.size() > 1) {
                q1.offer(q2.poll());
            }
            res = q2.poll();
            q1.offer(res);
        }

        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
