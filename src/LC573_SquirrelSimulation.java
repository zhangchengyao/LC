public class LC573_SquirrelSimulation {
    // the first nut matters
    // try to pick the first nut such that
    // dist(first nut, squirrel) is small and dist(first nut, tree) is large
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int bestFirst = 0;
        int d = getDist(tree, nuts[0]);
        int dist = d - getDist(squirrel, nuts[0]);
        int sum = d;
        for(int i = 1; i < nuts.length; i++) {
            d = getDist(tree, nuts[i]);
            sum += d;
            int cur = d - getDist(squirrel, nuts[i]);
            if(cur > dist) {
                dist = cur;
                bestFirst = i;
            }
        }

        return sum * 2 - dist;
    }

    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
