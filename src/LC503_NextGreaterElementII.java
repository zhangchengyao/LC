import java.util.Stack;

public class LC503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-2;i>=0;i--) stack.push(nums[i]);
        int[] res = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int num = nums[i];
            if(stack.isEmpty()){
                res[i] = -1;
                stack.push(num);
            }
            else{
                if(num<stack.peek()){
                    res[i] = stack.peek();
                    stack.push(num);
                }
                else{
                    while(!stack.isEmpty() && num>=stack.peek()) stack.pop();
                    if(stack.isEmpty()) res[i] = -1;
                    else res[i] = stack.peek();
                    stack.push(num);
                }
            }
        }
        return res;
    }
}
