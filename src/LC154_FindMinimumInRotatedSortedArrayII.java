public class LC154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                while (right >= left && nums[right] == nums[mid]) right--;
                if (right < left) return nums[left];
                if (nums[right] > nums[mid]) return nums[right + 1];
            }
        }
        
        return nums[left];
    }
}
