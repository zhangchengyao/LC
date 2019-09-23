public class LC762_PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for(int n = L; n <= R; n++) {
            int setBits = Integer.bitCount(n);
            if(isPrime(setBits)) res++;
        }

        return res;
    }

    private boolean isPrime(int n) {
        if(n == 1) return false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
