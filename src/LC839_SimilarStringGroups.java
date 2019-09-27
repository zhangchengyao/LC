import java.util.LinkedList;
import java.util.Queue;

public class LC839_SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        if(A == null || A.length < 1) return 0;

        Queue<String> q = new LinkedList<>();
        int groups = 0;
        while(true) {
            for(int i = 0; i < A.length; i++) {
                if(A[i] != null) {
                    q.offer(A[i]);
                    A[i] = null;
                    groups++;
                    break;
                }
            }
            if(q.isEmpty()) break;

            while(!q.isEmpty()) {
                String cur = q.poll();
                for(int i = 0; i < A.length; i++) {
                    if(A[i] != null && isSimilar(cur, A[i])) {
                        q.offer(A[i]);
                        A[i] = null;
                    }
                }
            }
        }

        return groups;
    }

    private boolean isSimilar(String X, String Y) {
        if(X.length() != Y.length()) return false;
        if(X.equals(Y)) return true;

        int d1 = -1;
        int d2 = -1;
        for(int i = 0; i < X.length(); i++) {
            if(X.charAt(i) != Y.charAt(i)) {
                if(d1 == -1) d1 = i;
                else if(d2 == -1) d2 = i;
                else return false;
            }
        }

        return X.charAt(d1) == Y.charAt(d2) && X.charAt(d2) == Y.charAt(d1);
    }
}
