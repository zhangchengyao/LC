import java.util.HashSet;

public class LC302_SmallestRectangleEnclosingBlackPixels {
    private int top = Integer.MAX_VALUE;
    private int right = Integer.MIN_VALUE;
    private int left = Integer.MAX_VALUE;
    private int bottom = Integer.MIN_VALUE;

    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0) return 0;

        dfs(image, x, y, new HashSet<>());

        return (bottom - top + 1) * (right - left + 1);
    }

    private void dfs(char[][] image, int x, int y, HashSet<String> visited) {
        if(!validPos(image, x, y) || image[x][y] == '0') return ;

        String pos = x + " " + y;

        if(visited.contains(pos)) return ;

        visited.add(pos);
        if(x < top) {
            top = x;
        }
        if(x > bottom) {
            bottom = x;
        }
        if(y < left) {
            left = y;
        }
        if(y > right) {
            right = y;
        }

        dfs(image, x - 1, y, visited);
        dfs(image, x + 1, y, visited);
        dfs(image, x, y - 1, visited);
        dfs(image, x, y + 1, visited);
    }

    private boolean validPos(char[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }
}
