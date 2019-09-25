import java.util.ArrayList;
import java.util.List;

public class LC784_LetterCasePermutation {
    private int diff = 'a' - 'A';

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        permute(res, new StringBuilder(S), 0);

        return res;
    }

    private void permute(List<String> res, StringBuilder sb, int start) {
        if(start == sb.length()) {
            if(Character.isLetter(sb.charAt(start - 1))) res.add(sb.toString());
            return;
        }

        res.add(sb.toString());

        for(int i = start; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(Character.isLetter(c)) {
                if(Character.isLowerCase(c)) {
                    sb.setCharAt(i, (char)(c - diff));
                } else {
                    sb.setCharAt(i, (char)(c + diff));
                }
                permute(res, sb, i + 1);
                sb.setCharAt(i, c);
            }
        }
    }
}
