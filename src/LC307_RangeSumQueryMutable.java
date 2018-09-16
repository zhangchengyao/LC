public class LC307_RangeSumQueryMutable {
    int[] sum;

    public LC307_RangeSumQueryMutable(int[] nums) {
        sum = new int[nums.length+1];
        for(int i=1;i<sum.length;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
    }

    public void update(int i, int val) {
        int ori = sum[i+1]-sum[i];
        int diff = val-ori;
        for(int k=i+1;k<sum.length;k++){
            sum[k] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}
