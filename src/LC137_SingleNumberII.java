public class LC137_SingleNumberII {
    public int singleNumber(int[] nums) {
        int b = 0;
        int a = 0;
        for(int i=0;i<nums.length;i++){
            b = (b^nums[i]) & ~a;
            a = (a^nums[i]) & ~b;
        }
        return b;
    }
}
