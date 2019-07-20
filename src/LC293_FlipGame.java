import java.util.ArrayList;
import java.util.List;

public class LC293_FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.substring(i, i + 2).equals("++")) {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }

        return res;
    }
}
