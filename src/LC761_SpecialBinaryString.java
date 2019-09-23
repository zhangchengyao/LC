import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC761_SpecialBinaryString {
    public String makeLargestSpecial(String S) {
        if(S == null || S.length() == 0) return S;

        List<String> parts = new ArrayList<>();
        int cnt = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
            }

            if(cnt == 0) {
                parts.add(1 + makeLargestSpecial(S.substring(start + 1, i)) + 0);
                start = i + 1;
            }
        }

        Collections.sort(parts);

        StringBuilder res = new StringBuilder();
        for(int i = parts.size() - 1; i >= 0; i--) {
            res.append(parts.get(i));
        }

        return res.toString();
    }
}
