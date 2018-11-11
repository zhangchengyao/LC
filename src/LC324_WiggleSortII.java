import java.util.Arrays;

public class LC324_WiggleSortII {
    // todo time: O(n) space: O(1)
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
