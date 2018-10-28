public class LC413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int lenAdd = 0;
        int res = 0;
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                lenAdd++;
                res += lenAdd;
            }else{
                lenAdd = 0;
            }
        }
        return res;
    }
//    public int numberOfArithmeticSlices(int[] A) {
//        int[][] dp = new int[A.length][A.length];
//        int res = 0;
//        for(int i=0;i<A.length-1;i++){
//            dp[i][i+1] = 1;
//        }
//        for(int l=3;l<=A.length;l++){
//            for(int i=0;i<=A.length-l;i++){
//                if(dp[i][i+l-2]==1 && A[i+l-1]-A[i+l-2]==A[i+l-2]-A[i+l-3]){
//                    dp[i][i+l-1] = 1;
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
}
