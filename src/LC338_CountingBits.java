public class LC338_CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        if(num==0) return res;
        for(int i=1;i<res.length;i++){
            if((i&1)==0){
                // it is an even number
                res[i] = res[i>>1];
            }else{
                // it is an odd number
                res[i] = res[i>>1]+1;
            }
        }
        return res;
    }
}
