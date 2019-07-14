import java.util.ArrayList;
import java.util.List;

public class LC247_StrobogrammaticNumberII {
    private char[] numbers = new char[]{'0','1','6','8','9'};
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        find(res, n, "");
        return res;
    }
    private void find(List<String> res, int n, String tmp){
        if(tmp.length() == n) {
            res.add(tmp);
            return;
        }

        for(char number: numbers) {
            StringBuilder sb = new StringBuilder(tmp);
            int idx = sb.length() / 2;
            if(number == '0') {
                if(tmp.equals("") && n != 1) continue;
                sb.insert(idx, number);
                if(sb.length() != n) sb.insert(idx, number);
            } else if(number == '1' || number == '8') {
                sb.insert(idx, number);
                if(sb.length() != n) sb.insert(idx, number);
            } else if(number == '6' || number == '9') {
                if(tmp.length() == n - 1) continue;
                if(number == '6') {
                    sb.insert(idx, "69");
                } else {
                    sb.insert(idx, "96");
                }
            }
            find(res, n, sb.toString());
        }
    }
}
