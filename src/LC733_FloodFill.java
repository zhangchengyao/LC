public class LC733_FloodFill {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;

        int original = image[sr][sc];
        fill(image, sr, sc, newColor, original);

        return image;
    }

    private void fill(int[][] image, int r, int c, int newColor, int original) {
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != original || image[r][c] == newColor) return ;

        image[r][c] = newColor;
        for(int[] dir: directions) {
            fill(image, dir[0] + r, dir[1] + c, newColor, original);
        }
    }
}
