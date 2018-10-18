import java.util.HashMap;
import java.util.Stack;

public class LC496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            if(stack.isEmpty()){
                map.put(nums2[i], -1);
                stack.push(nums2[i]);
            }
            else{
                if(nums2[i]<stack.peek()){
                    map.put(nums2[i], stack.peek());
                    stack.push(nums2[i]);
                }
                else{
                    while(!stack.isEmpty() && stack.peek()<nums2[i]) stack.pop();
                    if(stack.isEmpty()) map.put(nums2[i], -1);
                    else map.put(nums2[i], stack.peek());
                    stack.push(nums2[i]);
                }
            }
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<res.length;i++) res[i] = map.get(nums1[i]);
        return res;
    }
}
