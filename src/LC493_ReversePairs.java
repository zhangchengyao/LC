import java.util.Arrays;

public class LC493_ReversePairs {
    private int cnt = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);

        return cnt;
    }

    private void mergeSort(int[] nums, int l, int r){
        if(l>=r) return ;
        int mid = l + (r-l)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r){
        for(int i=l, j=mid+1;i<=mid;i++){
            while(j<=r && nums[i]/2.0>nums[j]) j++;
            cnt += j-mid-1;
        }

        Arrays.sort(nums, l, r+1);

    }
}
