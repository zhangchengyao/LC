public class LC396_RotateFunction {
    // F(k) = F(k-1) + sum - n * A[n-k];
    public int maxRotateFunction(int[] A) {
        int max = 0;
        int n = A.length;
        int f = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            f += i*A[i]; // f(0)
            sum += A[i];
        }
        max = f;
        for(int i=1;i<n;i++){
            f = f+sum-n*A[n-i];
            if(f>max) max = f;
        }
        return max;
    }
}
