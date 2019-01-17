import java.util.Stack;

public class LC456_132Pattern {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }

        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<third) return true;
            else{
                while( !stack.isEmpty() && nums[i]>stack.peek() ){
                    third = stack.pop();
                }
                stack.push(nums[i]);
            }
        }

        return false;
    }
}
