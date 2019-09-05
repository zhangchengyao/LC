import java.util.HashSet;

public class LC1062_LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String S) {
        int left = 0;
        int right = S.length() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(search(mid, S)) left = mid + 1;
            else right = mid - 1;
        }

        return left - 1;
    }

    private boolean search(int len, String S) {
        HashSet<String> mem = new HashSet<>();
        for(int i = 0; i <= S.length() - len; i++) {
            String cur = S.substring(i, i + len);
            if(mem.contains(cur)) return true;
            mem.add(cur);
        }

        return false;
    }
}
