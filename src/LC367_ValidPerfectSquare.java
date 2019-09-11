public class LC367_ValidPerfectSquare {
    // another solution: n^2 = 1 + 3 + 5 + ... + 2n - 1
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            double val = num / (double)mid;
            if(val == (double)mid) return true;
            else if(val < (double)mid) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}
