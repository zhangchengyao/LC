public class LC775_GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int preMax = -1;
        for(int i = 1; i < A.length; i++){
            if(preMax > A[i]) return false;
            preMax = Math.max(preMax, A[i - 1]);
        }

        return true;
    }

//    public boolean isIdealPermutation(int[] A) {
//        int local = 0;
//        for(int i=0;i<A.length-1;i++){
//            if(A[i]>A[i+1]) local++;
//        }
//        int global = countInversion(A, 0, A.length - 1, new int[A.length]);
//        return local == global;
//    }
//    private int countInversion(int[] A, int s, int e, int[] tmp) {
//        if(s >= e) return 0;
//        int mid = s + (e - s)/2;
//        int left = countInversion(A, s, mid, tmp);
//        int right = countInversion(A, mid + 1, e, tmp);
//        int res = left + right;
//        int i = s;
//        int j = mid + 1;
//        int k = s;
//        while(i <= mid && j <= e) {
//            if(A[i] < A[j]) {
//                tmp[k++] = A[i];
//                i++;
//            } else {
//                tmp[k++] = A[j];
//                j++;
//                res += (mid - i + 1);
//            }
//        }
//        while(i <= mid) tmp[k++] = A[i++];
//        while(j <= e) tmp[k++] = A[j++];
//        for(i = s; i <= e; i++) A[i] = tmp[i];
//        return res;
//    }
}
