public class LC693_BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n >>= 1;
        while(n > 0) {
            int cur = n & 1;
            if(prev == cur) return false;
            n >>= 1;
            prev = cur;
        }

        return true;
    }
}
