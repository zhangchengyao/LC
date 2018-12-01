import java.util.Arrays;

public class LC324_WiggleSortII {
    // space: O(1)
//    public void wiggleSort(int[] nums) {
//        int n = nums.length;
//        int median = findKthLargest(nums, (n+1)/2);
//        int left = 0;
//        int right = n-1;
//        int i = 0;
//        while(i<=right){
//            int idx = newIndex(i, n);
//            if(nums[idx]>median){
//                swap(nums, newIndex(left++, n), idx);
//                i++;
//            }else if(nums[idx]<median){
//                swap(nums, newIndex(right--, n), idx);
//            }else{
//                i++;
//            }
//        }
//    }
//    private int newIndex(int i, int n){
//        return (2*i+1)%(n|1);
//    }
//    private void swap(int[] nums, int i, int j){
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

    // time: O(nlogn), space: O(n)
    public void wiggleSort(int[] nums) {
        int[] tmp = new int[nums.length];
        for(int i=0;i<nums.length;i++) tmp[i] = nums[i];
        Arrays.sort(tmp);
        int r = nums.length-1;
        int k = (nums.length-1)/2;
        for(int i=0;i<nums.length;i++){
            nums[i] = (i&1) == 0?tmp[k--]:tmp[r--];
        }
    }
}
