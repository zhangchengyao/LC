import java.util.HashSet;
import java.util.Set;

public class LC771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for(char c: J.toCharArray()) jewels.add(c);

        int cnt = 0;
        for(char c: S.toCharArray()) cnt += jewels.contains(c) ? 1 : 0;

        return cnt;
    }
}
