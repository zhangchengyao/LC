public class LC292_NimGame {
    public boolean canWinNim(int n) {
        if(n==1 || n==2 || n==3) return true;
        if(n>=134882061) return n%4!=0; //actually no matter what n is, we can simply return n%4!=0
        boolean prev3 = true;
        boolean prev2 = true;
        boolean prev1 = true;
        for(int i=4;i<=n;i++){
            boolean next = !prev1 || !prev2 || !prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = next;
        }
        return prev1;
    }
}
