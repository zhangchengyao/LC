import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class LC675_CutOffTreesForGolfEvent {
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.size() == 0) return 0;

        TreeMap<Integer, int[]> tmap = new TreeMap<>();
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1){
                    tmap.put(forest.get(i).get(j), new int[]{i, j});
                }
            }
        }

        int[] cur = {0, 0};
        int steps = 0;

        for(int tree: tmap.keySet()){
            int step = bfs(forest, cur, tmap.get(tree));
            if(step >= 0) steps += step;
            else return -1;
            cur = tmap.get(tree);
        }

        return steps;
    }

    private int bfs(List<List<Integer>> forest, int[] src, int[] dest){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        q.offer(src);
        visited[src[0]][src[1]] = true;
        int level = 0;

        while(!q.isEmpty()){
            int cnt = q.size();
            for(int i = 0; i < cnt; i++){
                int[] cur = q.poll();
                if(cur[0] == dest[0] && cur[1] == dest[1]) return level;

                for(int k = 0; k < direction.length; k++){
                    int r = cur[0] + direction[k][0];
                    int c = cur[1] + direction[k][1];
                    if(isValid(forest, r, c) && !visited[r][c]){
                        q.offer(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }

            level ++;
        }

        return -1;
    }

    private boolean isValid(List<List<Integer>> forest, int r, int c){
        return r >= 0 && r < forest.size() && c >= 0 && c < forest.get(0).size() && forest.get(r).get(c) > 0;
    }
}
