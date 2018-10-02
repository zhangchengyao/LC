public class LC390_EliminationGame {
    public int lastRemaining(int n) {
        return eliminate(n, true);
    }
    private int eliminate(int n, boolean leftToRight){
        if(n==1) return n;
        if(leftToRight){
            return 2 * eliminate(n/2, false);
        }else{
            if((n&1)==1){
                return 2 * eliminate(n/2, true);
            }else{
                return 2 * eliminate(n/2, true)-1;
            }
        }
    }
}
