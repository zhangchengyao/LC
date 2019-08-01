import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC568_MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;

        HashSet<Integer>[] reachable = new HashSet[n];
        for(int i = 0; i < n; i++) {
            reachable[i] = new HashSet<>();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(flights[i][j] == 1 || i == j) {
                    reachable[j].add(i);
                }
            }
        }

        int[][] vacations = new int[n][k];
        vacations[0][0] = days[0][0];
        for(int i = 1; i < n; i++) {
            vacations[i][0] = flights[0][i] == 1 ? days[i][0] : 0;
        }

        for(int t = 1; t < k; t++) {
            for(int i = 0; i < n; i++) {
                for(int from: reachable[i]) {
                    if(vacations[from][t - 1] != 0 || i == 0) {
                        vacations[i][t] = Math.max(vacations[i][t], vacations[from][t - 1] + days[i][t]);
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, vacations[i][k - 1]);
        }

        return res;
    }
}
