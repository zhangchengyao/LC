import java.util.HashMap;
import java.util.List;

public class LC554_BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxCnt = 0;
        for(List<Integer> row: wall){
            int sum = 0;
            for(int i = 0; i < row.size() - 1; i++){
                int brick = row.get(i);
                sum += brick;
                count.put(sum, count.getOrDefault(sum, 0) + 1);
                maxCnt = Math.max(maxCnt, count.get(sum));
            }
        }

        return wall.size() - maxCnt;
    }
}
