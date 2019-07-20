import java.util.HashMap;

public class LC277_FindTheCelebrity {
    // O(n) solution
//    public int findCelebrity(int n) {
//        int res = 0;
//        for(int i = 0; i < n; i++){
//            if(res != i && knows(res, i)) res = i;
//        }
//        for(int i = 0; i < n; i++){
//            if(res != i && (knows(res, i) || !knows(i, res))) return -1;
//        }
//        return res;
//    }
    public int findCelebrity(int n) {
        int[] in = new int[n];
        int[] out = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(knows(i, j)){
                    in[j]++;
                    out[i]++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(in[i] == n-1 && out[i] == 0) return i;
        }
        return -1;
    }

    private boolean knows(int a, int b){return false;}
}
