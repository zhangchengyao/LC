public class LC80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int tmp_count;
        int i = 0;
        while(i<len){
            i++;
            tmp_count = 1;
            while(i<len && nums[i]==nums[i-1]){
                tmp_count++;
                i++;
            }
            if(tmp_count>2){
                int extra = tmp_count-2;
                for(int j=i;j<len;j++){
                    nums[j-extra] = nums[j];
                }
                len -= extra;
                i -= extra;
            }
        }
        for(i=0;i<len;i++){
            System.out.print(nums[i] + " ");
        }
        return len;
    }
}
