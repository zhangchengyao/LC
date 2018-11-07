public class LC858_MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int y = 0;
        int d = 0;
        while(true){
            y += q;
            d++;
            if(y%p==0){
                if(((y/p)&1)==1){
                    if((d&1)==1){
                        return 1;
                    }
                    else return 2;
                }
                else{
                    return 0;
                }
            }
        }
    }
}
