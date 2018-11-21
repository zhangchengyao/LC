import java.util.HashMap;

public class LC765_CouplesHoldingHands {
    // todo greedy algorithm, but why works?
    public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<>(); // label => index
        for(int i=0;i<row.length;i++) map.put(row[i], i);
        int res = 0;
        for(int i=0;i<row.length;i+=2){
            if((row[i]&1)==1){
                int index = map.get(row[i]-1);
                if(index!=i+1){
                    res++;
                    row[index] = row[i+1];
                    map.put(row[i+1], index);
                }
            }else{
                int index = map.get(row[i]+1);
                if(index!=i+1){
                    res++;
                    row[index] = row[i+1];
                    map.put(row[i+1], index);
                }
            }
        }
        return res;
    }
    // similar to counting sort
//    public int minSwapsCouples(int[] row) {
//        int res = 0, N = row.length;
//
//        int[] ptn = new int[N];
//        int[] pos = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            ptn[i] = (i % 2 == 0 ? i + 1 : i - 1);
//            pos[row[i]] = i;
//        }
//
//        for (int i = 0; i < N; i++) {
//            int j = ptn[pos[ptn[row[i]]]];
//            while(i!=j) {
//                swap(row, i, j);
//                swap(pos, row[i], row[j]);
//                res++;
//                j = ptn[pos[ptn[row[i]]]];
//            }
//        }
//
//        return res;
//    }
//
//    private void swap(int[] arr, int i, int j) {
//        int t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
//    }
}
