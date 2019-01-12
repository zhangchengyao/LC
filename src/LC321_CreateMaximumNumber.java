import java.util.ArrayList;
import java.util.List;

public class LC321_CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(k==0) return new int[]{};

        int m = nums1.length;
        int n = nums2.length;

        int[] best = new int[k];
        for(int i=Math.max(0, k-n);i<=Math.min(k, m);i++){
            // i = # elements from nums1
            int[] sub1 = maxSubArray(nums1, i);
            int[] sub2 = maxSubArray(nums2, k-i);
            best = max(best, merge(sub1, sub2), 0, 0);
        }

        return best;
    }

    private int[] maxSubArray(int[] nums, int k){
        int drop = nums.length - k;
        List<Integer> subArr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(drop>0){
                while(drop>0 && subArr.size()>0 && subArr.get(subArr.size()-1)<nums[i]){
                    subArr.remove(subArr.size()-1);
                    drop--;
                }
            }
            subArr.add(nums[i]);
        }

        int[] sub = new int[k];
        for(int i=0;i<sub.length;i++){
            sub[i] = subArr.get(i);
        }

        return sub;
    }

    private int[] merge(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;

        int[] merged = new int[m+n];
        int idx1 = 0;
        int idx2 = 0;
        for(int i=0;i<merged.length;i++){
            if(idx1==m) merged[i] = nums2[idx2++];
            else if(idx2==n) merged[i] = nums1[idx1++];
            else if(nums1[idx1]>nums2[idx2]) merged[i] = nums1[idx1++];
            else if(nums1[idx1]<nums2[idx2]) merged[i] = nums2[idx2++];
            else merged[i] = max(nums1, nums2, idx1, idx2)==nums1?nums1[idx1++]:nums2[idx2++];
        }
        return merged;
    }

    private int[] max(int[] nums1, int[] nums2, int start1, int start2){
        int i = 0;
        while(start1+i<nums1.length && start2+i<nums2.length && nums1[start1+i]==nums2[start2+i]) i++;

        if(start1+i==nums1.length) return nums2;
        else if(start2+i==nums2.length) return nums1;
        else return nums1[start1+i]>nums2[start2+i]?nums1:nums2;
    }
}
