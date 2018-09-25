import java.util.Arrays;

public class LC462_MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if(nums.length<=1) return 0;
        Arrays.sort(nums);
        long moves = 0;
        int median = nums[nums.length/2];
        for(int i=0;i<nums.length;i++){
            moves += Math.abs(nums[i]-median);
        }
        return (int)moves;
    }
}
