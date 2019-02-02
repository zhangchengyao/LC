public class LC546_RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int[][][] points = new int[boxes.length+1][boxes.length+1][boxes.length];

        return removeBox(boxes, 0, boxes.length-1, 0, points);
    }

    private int removeBox(int[] boxes, int start, int end, int k, int[][][] points){
        if(start > end) return 0;
        if(points[start][end][k] > 0) return points[start][end][k];

        while(start < end && boxes[start] == boxes[start+1]){
            start++;
            k++;
        }

        int maxPoint = (1 + k) * (1 + k) + removeBox(boxes, start + 1, end, 0, points);
        for(int m = start + 1; m <= end; m++){
            if(boxes[m] == boxes[start]){
                int point = removeBox(boxes, start + 1, m - 1, 0, points) + removeBox(boxes, m, end, 1 + k, points);
                maxPoint = Math.max(maxPoint, point);
            }
        }

        points[start][end][k] = maxPoint;
        return maxPoint;
    }
}
