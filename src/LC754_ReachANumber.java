public class LC754_ReachANumber {
    public int reachNumber(int target) {
        target = Math.abs(target);

        int n = (int)Math.ceil((-1 + Math.sqrt(1 + 8.0 * target)) / 2);
        int diff = n * (n + 1) / 2 - target;

        if((diff & 1) == 0) {
            return n;
        } else {
            return (n & 1) == 1 ? n + 2 : n + 1;
        }
    }
}
