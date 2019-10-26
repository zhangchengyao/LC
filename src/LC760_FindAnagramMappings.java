import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC760_FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            map.putIfAbsent(B[i], new Stack<>());
            map.get(B[i]).push(i);
        }

        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]).pop();
        }

        return res;
    }
}
