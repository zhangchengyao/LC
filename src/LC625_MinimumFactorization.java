public class LC625_MinimumFactorization {
    public int smallestFactorization(int a) {
        if(a < 10) return a;

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i > 1; i--) {
            if(a == 1) break;
            while(a > 1 && a % i == 0) {
                a /= i;
                sb.append(i);
            }
        }

        String res = sb.reverse().toString();
        if(a != 1 || Long.parseLong(res) > Integer.MAX_VALUE) return 0;
        else return Integer.parseInt(res);
    }
}
