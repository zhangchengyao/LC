import java.util.Stack;

public class LC232_ImplementQueueUsingStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public LC232_ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.isEmpty()){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        if(stack2.isEmpty()) return Integer.MIN_VALUE;
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) return Integer.MIN_VALUE;
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
