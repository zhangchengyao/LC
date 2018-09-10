import java.util.PriorityQueue;

public class LC703_KthLargestElementInAStream {
    PriorityQueue<Integer> data;
    int k;
    public LC703_KthLargestElementInAStream(int k, int[] nums) {
        data = new PriorityQueue<>();
        this.k = k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(data.size()<k){
            data.offer(val);
        }else{
            if(val>data.peek()){
                data.poll();
                data.offer(val);
            }
        }
        return data.peek();
    }
}
