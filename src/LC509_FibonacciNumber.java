public class LC509_FibonacciNumber {
    public int fib(int N) {
        if(N<2) return N;

        int a = 0;
        int b = 1;
        int c = 0;
        for(int i=2;i<=N;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
