public class LC330_PatchingArray {
    public int minPatches(int[] nums, int n) {
        int cnt = 0;
        long miss = 1;
        int idx = 0;
        while(miss<=n){
            if(idx==nums.length || nums[idx]>miss){
                cnt++;
                miss += miss;
            } else {
                miss += nums[idx++];
            }
        }

        return cnt;
    }
}
