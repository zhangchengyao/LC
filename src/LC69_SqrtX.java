public class LC69_SqrtX {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(x/mid==mid) return mid;
            else if(x/mid<mid) right = mid-1;
            else left = mid+1;
        }
        return right;
        // long res = x;
        // while(res*res>x) res = (res+x/res)/2;
        // return (int)res;
    }
}
