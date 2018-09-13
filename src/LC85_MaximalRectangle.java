public class LC85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int res = 0;
        int[] heights = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<heights.length;j++){
                if(matrix[i][j]=='1') heights[j] += 1;
                else heights[j] = 0;
            }
            int curMax = largestRectangleArea(heights);
            if(curMax>res) res = curMax;
        }
        return res;
    }
    private int largestRectangleArea(int[] heights) {
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
