public class LC162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    private int find(int[] nums, int l, int r){
        if(l>r) return -1;
        if(l==r) return l;
        int mid = l+(r-l)/2;
        if((mid==l || nums[mid]>nums[mid-1]) && (mid==r||nums[mid]>nums[mid+1])) return mid;
        int res = -1;
        if(mid!=l && nums[mid]<nums[mid-1]) res = find(nums, l, mid-1);
        if(res!=-1) return res;
        if(mid!=r && nums[mid]<nums[mid+1]) res = find(nums, mid+1, r);
        return res;
    }
}
