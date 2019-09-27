import java.util.HashSet;
import java.util.Set;

public class LC840_MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length - 2; i++) {
            for(int j = 0; j < grid[0].length - 2; j++) {
                if(check(grid, i, j)) res++;
            }
        }

        return res;
    }

    private boolean check(int[][] grid, int r, int c) {
        Set<Integer> digits = new HashSet<>();
        for(int i = r; i < r + 3; i++) {
            int sum = 0;
            for(int j = c; j < c + 3; j++) {
                if(digits.contains(grid[i][j]) || grid[i][j] > 9) return false;
                digits.add(grid[i][j]);
                sum += grid[i][j];
            }
            if(sum != 15) return false;
        }

        for(int j = c; j < c + 3; j++) {
            int sum = 0;
            for(int i = r; i < r + 3; i++) {
                sum += grid[i][j];
            }
            if(sum != 15) return false;
        }

        return (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] == 15) && (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] == 15);
    }
}
