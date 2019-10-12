import java.util.Arrays;

public class LC899_OrderlyQueue {
    // difficult to think of
    public String orderlyQueue(String S, int K) {
        if(K > 1) {
            char[] arr = S.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }

        String smallest = S;
        S = S + S;
        for(int i = 1; i < smallest.length(); i++) {
            String cand = S.substring(i, i + smallest.length());
            if(cand.compareTo(smallest) < 0) smallest = cand;
        }

        return smallest;
    }
}
