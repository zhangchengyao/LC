import java.util.Arrays;

public class LC280_WiggleSort {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(((j&1) == 1 && nums[j] < nums[i]) || ((j&1) == 0 && nums[j] > nums[i])) swap(nums, i, j);
            i++;
            j++;
        }
    }
//    public void wiggleSort(int[] nums) {
//        Arrays.sort(nums);
//        for(int i=1;i<nums.length-1;i+=2){
//            swap(nums, i, i+1);
//        }
//    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
