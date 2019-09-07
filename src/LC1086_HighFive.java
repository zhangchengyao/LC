import java.util.PriorityQueue;

public class LC1086_HighFive {
    public int[][] highFive(int[][] items) {
        PriorityQueue<Integer>[] stScores = new PriorityQueue[1001];
        int num = 0;

        for(int[] item: items) {
            int st = item[0];
            int score = item[1];

            if(stScores[st] == null) {
                stScores[st] = new PriorityQueue<>();
                num++;
            }
            stScores[st].offer(score);
            if(stScores[st].size() > 5) stScores[st].poll();
        }

        int[][] res = new int[num][2];
        int idx = 0;
        for(int i = 1; i < stScores.length; i++) {
            if(stScores[i] != null) {
                int sum = 0;
                for(int score: stScores[i]) {
                    sum += score;
                }
                res[idx++] = new int[]{i, sum / 5};
            }
        }

        return res;
    }
}
