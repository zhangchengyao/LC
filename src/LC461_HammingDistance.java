public class LC461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = 0;
        for(int i=0;i<32;i++){
            if((x&1)!=(y&1)) res++;
            x >>>= 1;
            y >>>= 1;
            if(x==0 && y==0) break;
        }
        return res;
    }
}
