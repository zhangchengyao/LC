public class LC812_LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                for(int k = j + 1; k < points.length; k++) {
                    if(isValid(points[i], points[j], points[k])) {
                        double ab = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                        double bc = Math.sqrt(Math.pow(points[j][0] - points[k][0], 2) + Math.pow(points[j][1] - points[k][1], 2));
                        double ac = Math.sqrt(Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2));
                        double p = (ab + bc + ac) / 2;
                        maxArea = Math.max(maxArea, Math.sqrt(p * (p - ab) * (p - bc) * (p - ac)));
                    }
                }
            }
        }

        return maxArea;
    }

    private boolean isValid(int[] A, int[] B, int[] C) {
        int x1 = B[0] - A[0];
        int y1 = B[1] - A[1];
        int x2 = C[0] - A[0];
        int y2 = C[1] - A[1];
        return x2 * y1 != x1 * y2;
    }
}
