import java.util.ArrayList;
import java.util.List;

public class LC842_SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= S.length() - 2; i++) {
            if(i > 1 && S.charAt(0) == '0') break;

            long prev2 = Long.parseLong(S.substring(0, i));
            if(prev2 > Integer.MAX_VALUE) break;

            for(int j = i + 1; j <= S.length() - 1; j++) {
                if(j > i + 1 && S.charAt(i) == '0') break;

                prev2 = Long.parseLong(S.substring(0, i));
                long prev1 = Long.parseLong(S.substring(i, j));
                if(prev1 > Integer.MAX_VALUE) break;

                res.add((int)prev2);
                res.add((int)prev1);
                int idx = j;
                while(idx < S.length()) {
                    long next = prev2 + prev1;
                    if(next > Integer.MAX_VALUE) break;

                    String nextStr = Long.toString(next);
                    if(idx + nextStr.length() > S.length() || !S.substring(idx, idx + nextStr.length()).equals(nextStr)) break;
                    prev2 = prev1;
                    prev1 = next;
                    idx += nextStr.length();
                    res.add((int)next);
                }

                if(idx == S.length()) return res;
                res.clear();
            }
        }

        return res;
    }
}
