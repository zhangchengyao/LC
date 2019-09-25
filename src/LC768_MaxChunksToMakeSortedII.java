public class LC768_MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] minRight = new int[n];
        int[] maxLeft = new int[n];
        minRight[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(arr[i], minRight[i + 1]);
        }
        maxLeft[0] = arr[0];
        for(int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(arr[i], maxLeft[i - 1]);
        }

        int chunks = 1;
        for(int i = 1; i < arr.length; i++) {
            if(maxLeft[i - 1] <= minRight[i]) chunks++;
        }

        return chunks;
    }
}
