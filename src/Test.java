public class Test {
    public static void main(String[] args){
        LC209_MinimumSizeSubarraySum lc = new LC209_MinimumSizeSubarraySum();
        int[] arr = new int[]{1,2,3,4,5};
        int len = lc.minSubArrayLen(15,arr);
        System.out.println(len);
    }
}
