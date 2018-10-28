public class LC365_WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        // Bezout's lemma
        if(z>x+y) return false;
        return z==0 || z%gcd(x, y)==0;
    }
    private int gcd(int x, int y){
        while(y!=0){
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
