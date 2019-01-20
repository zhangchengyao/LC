public class LC479_LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if(n==1) return 9;

        long upper = (long)Math.pow(10, n) - 1L;
        long lower = (long)Math.pow(10, n-1);

        for(long i=upper;i>=lower;i--){
            long palin = createPalindrome(i);

            for(long factor=upper;factor>=lower;factor--){
                if(palin/factor>upper) break;
                if(palin%factor==0) return (int)(palin % 1337);
            }
        }

        return -1;
    }

    private long createPalindrome(long x){
        StringBuilder sb = new StringBuilder(Long.toString(x));
        sb.reverse().insert(0, Long.toString(x));
        return Long.parseLong(sb.toString());
    }
}
