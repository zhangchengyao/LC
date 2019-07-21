public class LC307_RangeSumQueryMutable {
    private int[] nums;
    private int[] bit;

    public LC307_RangeSumQueryMutable(int[] nums) {
        this.nums = new int[nums.length + 1];
        bit = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        for(int k = i + 1; k < bit.length; k += (k & -k)){
            bit[k] += diff;
        }
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(j+1) - getSum(i);
    }
    private int getSum(int i){
        int res = 0;
        for(int k = i; k > 0; k -= (k & -k)){
            res += bit[k];
        }
        return res;
    }
//    int[] sum;
//
//    public LC307_RangeSumQueryMutable(int[] nums) {
//        sum = new int[nums.length+1];
//        for(int i=1;i<sum.length;i++){
//            sum[i] = sum[i-1]+nums[i-1];
//        }
//    }
//
//    public void update(int i, int val) {
//        int ori = sum[i+1]-sum[i];
//        int diff = val-ori;
//        for(int k=i+1;k<sum.length;k++){
//            sum[k] += diff;
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return sum[j+1]-sum[i];
//    }
}
