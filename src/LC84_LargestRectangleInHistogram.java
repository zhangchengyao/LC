public class LC84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        int res = heights[0];
        for(int i=0;i<heights.length;i++){
            if(i<heights.length-1 && heights[i]<=heights[i+1]) continue;
            int minHeight = heights[i];
            int j = i-1;
            int localMax = heights[i];
            while(j>=0){
                if(minHeight>heights[j]) minHeight = heights[j];
                if(minHeight*(i-j+1)>localMax) localMax = minHeight*(i-j+1);
                if(localMax>res) res = localMax;
                j--;
            }
        }
        return res;
    }
}
