public class LC441_ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int)( (-1+Math.sqrt(1+8L*n))/2 );
    }
}
