public class LC526_BeautifulArrangement {
    public int countArrangement(int N) {
        int[] nums = new int[N];
        for(int i = 1; i <= N; i++) nums[i - 1] = i;
        return count(nums, 0);
    }
    private int count(int[] nums, int cur) {
        if(cur == nums.length - 1) {
            if((cur + 1) % nums[cur] == 0 || nums[cur] % (cur + 1) == 0) return 1;
            else return 0;
        }
        int res = 0;
        for(int i = cur; i < nums.length; i++){
            if((cur + 1) % nums[i] == 0 || nums[i] % (cur + 1) == 0){
                swap(nums, cur, i);
                res += count(nums, cur + 1);
                swap(nums, cur, i);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
