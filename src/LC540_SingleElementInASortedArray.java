public class LC540_SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for(int i: nums) res ^= i;
        return res;
    }
}
