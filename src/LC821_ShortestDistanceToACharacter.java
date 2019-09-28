import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC821_ShortestDistanceToACharacter {
//    public int[] shortestToChar(String S, char C) {
//        int[] res = new int[S.length()];
//
//        int prev = -S.length() - 1;
//        for(int i = 0; i < S.length(); i++) {
//            if(S.charAt(i) == C) {
//                res[i] = 0;
//                prev = i;
//            } else {
//                res[i] = i - prev;
//            }
//        }
//
//        prev = S.length() << 1;
//        for(int i = S.length() - 1; i >= 0; i--) {
//            if(S.charAt(i) == C) {
//                prev = i;
//            } else {
//                res[i] = Math.min(res[i], prev - i);
//            }
//        }
//
//        return res;
//    }

    public int[] shortestToChar(String S, char C) {
        List<Integer> cIdx = new ArrayList<>();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) cIdx.add(i);
        }

        int[] res = new int[S.length()];
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) {
                res[i] = 0;
            } else {
                int idx = Collections.binarySearch(cIdx, i);
                idx = -idx - 1;
                int leftDist = idx > 0 ? i - cIdx.get(idx - 1) : Integer.MAX_VALUE;
                int rightDist = idx < cIdx.size() ? cIdx.get(idx) - i : Integer.MAX_VALUE;
                res[i] = Math.min(leftDist, rightDist);
            }
        }

        return res;
    }
}
