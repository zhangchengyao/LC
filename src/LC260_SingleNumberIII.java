import java.util.ArrayList;

public class LC260_SingleNumberIII {
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
