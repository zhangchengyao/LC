import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC315_CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        Integer[] counts = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            int idx = binarySearch(sorted, nums[i]);
            counts[i] = idx;
            sorted.add(idx, nums[i]);
        }

        return Arrays.asList(counts);
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid) >= target) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}
