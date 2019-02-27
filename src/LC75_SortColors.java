public class LC75_SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) return;

        int l = 0;
        int r = nums.length - 1;
        while(l < nums.length && nums[l] == 0) l++;
        if(l == nums.length) return;
        while(r >= 0 && nums[r] == 2) r--;
        if(r == -1) return;

        int cur = l;
        while(cur <= r){
            if(nums[cur] == 0){
                if(nums[l] == 0){
                    cur++;
                    l = cur;
                } else {
                    swap(nums, cur, l++);
                }
            } else if(nums[cur] == 2){
                swap(nums, cur, r--);
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
