import java.util.HashSet;

public class LC564_FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        int len = n.length();
        HashSet<Long> set = new HashSet<>();
        set.add((long)Math.pow(10, len - 1) - 1);
        set.add((long)Math.pow(10, len) + 1);

        String left = n.substring(0, (len + 1) / 2);
        long leftVal = Long.parseLong(left);

        for(int i = -1; i <= 1; i++){
            String left_prime = String.valueOf(leftVal + i);
            String reversed = new StringBuilder(left_prime).reverse().toString();
            set.add(Long.parseLong(left_prime + (len % 2 == 0 ? reversed : reversed.substring(1))));
        }

        long minDiff = Integer.MAX_VALUE;
        long closest = 0;
        for(long cand: set){
            long diff = Math.abs(Long.parseLong(n) - cand);
            if(diff == 0) continue;

            if(diff < minDiff){
                minDiff = diff;
                closest = cand;
            } else if(diff == minDiff){
                closest = Math.min(closest, cand);
            }
        }

        return String.valueOf(closest);
    }
}
