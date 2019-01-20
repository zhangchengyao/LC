import java.util.Collections;
import java.util.PriorityQueue;

public class LC480_SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> big = new PriorityQueue<>();

        double[] medians = new double[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(small.size()+big.size()<k){
                if(small.size()==big.size()) insertIntoSmall(small, big, nums[i]);
                else insertIntoBig(small, big, nums[i]);
            } else {
                if(small.contains(nums[i-k])) small.remove(nums[i-k]);
                else big.remove(nums[i-k]);

                if(small.size()<=big.size()) insertIntoSmall(small, big, nums[i]);
                else insertIntoBig(small, big, nums[i]);
            }

            if(i>=k-1){
                medians[i-k+1] = (k&1)==1?small.peek():small.peek()/2.0+big.peek()/2.0;
            }
        }

        return medians;
    }

    private void insertIntoSmall(PriorityQueue<Integer> small, PriorityQueue<Integer> big, int x){
        if(!big.isEmpty() && x>big.peek()){
            small.offer(big.poll());
            big.offer(x);
        } else {
            small.offer(x);
        }
    }

    private void insertIntoBig(PriorityQueue<Integer> small, PriorityQueue<Integer> big, int x){
        if(x<small.peek()){
            big.offer(small.poll());
            small.offer(x);
        } else {
            big.offer(x);
        }
    }
}
