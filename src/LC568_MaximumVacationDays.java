import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC568_MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = days.length; // # of cities
        int k = days[0].length; // # of weeks
        int[] reach = new int[n];
        Arrays.fill(reach, -1);
        bfs(flights, reach);
        int[][] dp = new int[n][k];
        dp[0][0] = days[0][0];
        for(int i=1;i<n;i++){
            dp[i][0] = flights[0][i]==1?days[i][0]:0;
        }
        for(int j=1;j<k;j++){
            for(int i=0;i<n;i++){
                dp[i][j] = reach[i]!=-1&&reach[i]<=j?dp[i][j-1]+days[i][j]:0;
                for(int t=0;t<n;t++){
                    if(flights[t][i]==1 && reach[t]!=-1 && reach[t]<j){
                        dp[i][j] = Math.max(dp[i][j], dp[t][j-1]+days[i][j]);
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dp[i][k-1]>res) res = dp[i][k-1];
        }
        return res;
    }
    private void bfs(int[][] flights, int[] reach){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[reach.length];
        int cnt;
        int layer = 0;
        q.offer(0);
        reach[0] = 0;
        visited[0] = true;
        while(!q.isEmpty()){
            cnt = q.size();
            for(int i=0;i<cnt;i++){
                int cur = q.poll();
                for(int j=0;j<flights.length;j++){
                    if(flights[cur][j]==1 && !visited[j]){
                        visited[j] = true;
                        reach[j] = layer;
                        q.offer(j);
                    }
                }
            }
            layer++;
        }
    }
}
