public class LC313_SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                int num = primes[j] * ugly[pointers[j]];
                min = Math.min(min, num);
            }
            for(int j=0;j<primes.length;j++){
                if(min==primes[j]*ugly[pointers[j]]) pointers[j]++;
            }
            ugly[i] = min;
        }
        return ugly[n-1];
    }
}
