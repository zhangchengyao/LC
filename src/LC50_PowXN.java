public class LC50_PowXN {
    public double myPow(double x, int n) {
        if(n==0 || x==1) return 1.0;
        if(x==0) return 0.0;
        if(n<0) return 1/(x*powRec(x, -(n+1)));
        else return powRec(x, n);
    }
    private double powRec(double x, int n){
        if(n==0 || x==1.0) return 1.0;
        if(x==0.0) return 0.0;
        double half = powRec(x, n/2);
        double res;
        if((n&1)==1) res = half*half*x;
        else res = half*half;
        return res;
    }
}
