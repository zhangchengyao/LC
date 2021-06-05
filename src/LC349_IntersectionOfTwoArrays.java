import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (i > 0 && nums1[i] == nums1[i - 1]) continue;
            
            idx = binarySearch(nums2, idx, nums1[i]);
            if (idx == nums2.length) break;
            
            if (nums1[i] == nums2[idx]) res.add(nums1[i]);
        }
        
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) resArr[i] = res.get(i);
        return resArr;
    }
    
    private int binarySearch(int[] arr, int left, int target) {
        int l = left;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        
        return l;
    }
}
