import java.util.Stack;

public class LC739_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        // descending stack
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = T.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = 0;
            else res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
