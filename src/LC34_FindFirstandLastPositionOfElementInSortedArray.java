public class LC34_FindFirstandLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        int leftmost = binarySearch(nums, target, true);
        if(leftmost == nums.length || nums[leftmost] != target){
            return res;
        }
        int rightmost = binarySearch(nums, target, false);
        res[0] = leftmost;
        res[1] = rightmost - 1;
        return res;
    }

    private int binarySearch(int[] nums, int target, boolean left){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > target || (left && nums[mid] == target)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
