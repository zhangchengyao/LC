public class LC162_FindPeakElement {
    // [1,2,3,2,3,4,4,4,4]
    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    private int find(int[] nums, int l, int r){
        if(l>r) return -1;
        if(l==r) return l;
        int mid = l+(r-l)/2;
        if((mid==l || nums[mid]>nums[mid-1]) && (mid==r||nums[mid]>nums[mid+1])) return mid;
        int res = -1;
        int cur = mid;
        while(cur>l && nums[cur]>=nums[cur-1]) cur--;
        if(cur!=l) res = find(nums, l, cur-1);
        if(res!=-1) return res;
        cur = mid;
        while(cur<r && nums[cur]>=nums[cur+1]) cur++;
        if(cur!=r) res = find(nums, cur+1, r);
        return res;
    }
}
