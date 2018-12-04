public class LC283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int num = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                for(int j=i;j<nums.length-1;j++){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
                i--;
            }
            num++;
            if(num==nums.length) break;
        }
    }
}
