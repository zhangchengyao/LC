public class LC398_RandomPickIndex {
    // reservoir sampling
    int[] data;

    public LC398_RandomPickIndex(int[] nums) {
        data = nums;
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for(int i=0;i<data.length;i++){
            if(target==data[i]){
                count++;
                if(res==-1){
                    res = i;
                }else{
                    int index = (int)(Math.random()*count);
                    if(index==0) res = i;
                }
            }
        }
        return res;
    }
}
