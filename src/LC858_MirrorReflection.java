public class LC858_MirrorReflection {
//    public int mirrorReflection(int p, int q) {
//        int y = p / gcd(p, q) * q;
//        if((y / p & 1) == 1) {
//            if((y / q & 1) == 1) return 1;
//            else return 2;
//        } else {
//            return 0;
//        }
//    }
//
//    private int gcd(int p, int q) {
//        if(q == 0) return p;
//        return gcd(q, p % q);
//    }

    public int mirrorReflection(int p, int q) {
        int y = 0;
        int d = 0;
        while(true){
            y += q;
            d++;
            if(y % p == 0){
                if(((y / p) & 1) == 1){
                    if((d & 1) == 1){
                        return 1;
                    } else {
                        return 2;
                    }
                } else{
                    return 0;
                }
            }
        }
    }
}
