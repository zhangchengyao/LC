public class LC769_MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int res = 0;
        int curMax = -1;
        for(int p = 0; p < arr.length; p++) {
            curMax = Math.max(curMax, arr[p]);
            if(p == curMax){
                res++;
                curMax = -1;
            }
        }
        return res;
    }
}
