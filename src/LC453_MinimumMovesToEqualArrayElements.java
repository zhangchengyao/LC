public class LC453_MinimumMovesToEqualArrayElements {
    // increase n-1 elements by 1 = decrease 1 element by 1
    public int minMoves(int[] nums) {
        if(nums.length<=1) return 0;
        int min = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min) min = nums[i];
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res += (nums[i]-min);
        }
        return res;
    }
}
