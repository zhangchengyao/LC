import java.util.Arrays;

public class LC215_KthLargestElementInAnArray {
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];
//    }
    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length-1);
    }
    private int find(int[] nums, int k, int left, int right){
        if(left==right) return nums[left];
        if(left==right-1) return k==1?Math.max(nums[left], nums[right]):Math.min(nums[left], nums[right]);
        int pivot = medianOf3(nums, left, right);
        int i = left+2;
        int j = i;
        while(j<=right){
            if(nums[j]<pivot){
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, left+1, i-1);
        if(right-i+2==k) return pivot;
        else if(right-i+2<k) return find(nums, k-(right-i+2), left, i-2);
        else return find(nums, k, i, right);
    }
    private int medianOf3(int[] nums, int left, int right){
        int mid = left + (right-left)/2;
        if(nums[left]>nums[mid]) swap(nums, left, mid);
        if(nums[left]>nums[right]) swap(nums, left, right);
        if(nums[mid]>nums[right]) swap(nums, mid, right);
        swap(nums, left+1, mid);
        return nums[left+1];
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
