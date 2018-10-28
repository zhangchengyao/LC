public class LC303_RangeSumQueryImmutable {
    int[] sum;

    public LC303_RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length+1];
        for(int i=1;i<sum.length;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}
