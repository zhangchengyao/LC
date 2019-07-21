import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC296_BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        List<Integer> homeRows = new ArrayList<>();
        List<Integer> homeCols = new ArrayList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    homeRows.add(i);
                    homeCols.add(j);
                }
            }
        }

        Collections.sort(homeRows);
        Collections.sort(homeCols);

        int best = 0;

        int i = 0;
        int j = homeRows.size() - 1;
        while(i < j) {
            best += homeRows.get(j) - homeRows.get(i);
            best += homeCols.get(j) - homeCols.get(i);
            i++;
            j--;
        }

        return best;
    }
}
