import java.util.HashSet;

public class LC1100_FindKLengthSubstringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if(S.length() < K) return 0;

        HashSet<Character> set = new HashSet<>();
        int cnt = 0;
        int i = 0;
        int j = 0;
        while(j < S.length()) {
            if(set.contains(S.charAt(j))) {
                while(S.charAt(i) != S.charAt(j)) {
                    set.remove(S.charAt(i++));
                }
                set.remove(S.charAt(i++));
            }
            set.add(S.charAt(j++));
            if(j - i == K) {
                cnt++;
                set.remove(S.charAt(i++));
            }
        }

        return cnt;
    }
}
