public class LC769_MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        if(arr==null || arr.length==0) return 0;
        int res = 0;
        int p = 0;
        int curMax = -1;
        while(p<arr.length){
            curMax = Math.max(curMax, arr[p]);
            if(p==curMax){
                res++;
                curMax = -1;
            }
            p++;
        }
        return res;
    }
}
