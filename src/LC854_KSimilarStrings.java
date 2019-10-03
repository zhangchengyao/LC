import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC854_KSimilarStrings {
    public int kSimilarity(String A, String B) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(A);
        visited.add(A);

        int res = 0;
        while(!q.isEmpty()) {
            int cnt = q.size();
            for(int t = 0; t < cnt; t++) {
                String cur = q.poll();
                if(cur.equals(B)) return res;

                char[] arr = cur.toCharArray();
                int i = 0;
                while(i < arr.length && arr[i] == B.charAt(i)) i++;
                if(i == arr.length) continue;

                int j = i + 1;
                while(j < arr.length) {
                    if(arr[j] == B.charAt(i)) {
                        swap(arr, i, j);
                        String cand = new String(arr);
                        if(!visited.contains(cand)) {
                            visited.add(cand);
                            q.offer(cand);
                        }
                        swap(arr, i, j);
                    }
                    j++;
                }
            }
            res++;
        }

        return res;
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
