public class LC1176_DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int score = 0;
        int runningSum = 0;
        int i = 0;
        int j = 0;
        while(j < calories.length) {
            runningSum += calories[j++];
            if(j - i == k) {
                if(runningSum < lower) score--;
                else if(runningSum > upper) score++;
                runningSum -= calories[i++];
            }
        }

        return score;
    }
}
