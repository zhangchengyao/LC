public class LC552_StudentAttendanceRecordII {
    public int checkRecord(int n) {
        if(n==1) return 3;
        int mod = 1000000007;
        int[] P = new int[n+1];
        int[] A = new int[n+1];
        int[] L = new int[n+1];
        P[1] = 1;
        P[2] = 3;
        A[0] = 1;
        A[1] = 1;
        A[2] = 2;
        L[1] = 1;
        L[2] = 3;
        for(int i=3;i<P.length;i++){
            P[i] = ((P[i-1]+A[i-1])%mod+L[i-1])%mod;
            A[i] = ((A[i-1]+A[i-2])%mod+A[i-3])%mod;
            L[i] = ((P[i-1]+A[i-1])%mod+(P[i-2]+A[i-2])%mod)%mod;
        }
        return ((P[n]+A[n])%mod+L[n])%mod;
    }

}
