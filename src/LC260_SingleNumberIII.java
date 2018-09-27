import java.util.ArrayList;

public class LC260_SingleNumberIII {
    /* a genius bit manipulation solution */
//    public int[] singleNumber(int[] nums) {
//        int[] res = new int[2];
//        int xor = 0;
//        for(int i=0;i<nums.length;i++){
//            xor ^= nums[i];
//        }
//        xor &= -xor;
//        for(int i=0;i<nums.length;i++){
//            if((xor & nums[i])==0) res[0] ^= nums[i];
//            else res[1] ^= nums[i];
//        }
//        return res;
//    }
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!res.contains(nums[i])){
                res.add(nums[i]);
            }else{
                res.remove((Integer)nums[i]);
            }
        }
        int[] resArr = new int[2];
        resArr[0] = res.get(0);
        resArr[1] = res.get(1);
        return resArr;
    }
}
