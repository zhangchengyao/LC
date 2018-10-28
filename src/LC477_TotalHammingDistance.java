public class LC477_TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int num0, num1;
        for(int i=0;i<32;i++){
            num0 = 0;
            num1 = 0;
            for(int j=0;j<nums.length;j++){
                if((nums[j]&1)==0) num0++;
                else num1++;
                nums[j] >>>= 1;
            }
            total += num0*num1;
        }
        return total;
    }
}
