import java.util.LinkedList;

public class LC239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<1) return new int[]{};

        int[] maxWindow = new int[nums.length-k+1];

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(!list.isEmpty() && list.getFirst()==i-k) list.removeFirst();
            while(!list.isEmpty() && nums[list.getLast()]<nums[i]) list.removeLast();
            list.addLast(i);

            if(i>=k-1) maxWindow[i-k+1] = nums[list.getFirst()];
        }

        return maxWindow;
    }
}
