import java.util.HashSet;

public class LC294_FlipGameII {
    private HashSet<String> fails = new HashSet<>();

    public boolean canWin(String s) {
        if(fails.contains(s)) return false;

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.substring(i, i + 2).equals("++")) {
                if(!canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
                    return true;
                }
            }
        }

        fails.add(s);
        return false;
    }
}
