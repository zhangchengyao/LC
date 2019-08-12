import java.util.Stack;

public class LC716_MaxStack {
    private Stack<Integer> maxStack;
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public LC716_MaxStack() {
        maxStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty() || x >= maxStack.peek()){
            maxStack.push(x);
        }
    }

    public int pop() {
        int val = stack.pop();
        if(maxStack.peek() == val){
            maxStack.pop();
        }
        return val;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();
        Stack<Integer> buffer = new Stack<>();
        while(!stack.isEmpty() && stack.peek() != max){
            buffer.push(stack.pop());
        }

        stack.pop();

        while(!buffer.isEmpty()){
            push(buffer.pop());
        }

        return max;
    }
}
