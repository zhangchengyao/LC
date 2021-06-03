public class LC162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length);
    }
    
    private int search(int[] nums, int left, int right) {
        if (left == right - 1) return left;
        int mid = left + (right - left) / 2;
        int mid2 = mid - 1;
        if (nums[mid2] < nums[mid]) return search(nums, mid, right);
        else return search(nums, left, mid);
    }
}
