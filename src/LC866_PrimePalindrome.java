public class LC866_PrimePalindrome {
    public int primePalindrome(int N) {
        // key observation: even-length palindrome can be divided by 11
        while(true) {
            if(N >= 12 && N < 100) N = 101;
            if(N >= 1000 && N < 10000) N = 10001;
            if(N >= 100000 && N < 1000000) N = 1000001;
            if(N >= 10000000 && N < 100000000) N = 100000001;

            if(isPalindrome(N) && isPrime(N)) return N;

            N++;
        }
    }

    private boolean isPalindrome(int N) {
        int reversed = 0;
        int num = N;
        while(num > 0) {
            int digit = num % 10;
            reversed = digit + 10 * reversed;
            num /= 10;
        }

        return reversed == N;
    }

    private boolean isPrime(int N) {
        if(N == 1) return false;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(N % i == 0) return false;
        }

        return true;
    }
}
