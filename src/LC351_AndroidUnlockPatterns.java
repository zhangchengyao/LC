import java.util.HashMap;

public class LC351_AndroidUnlockPatterns {
    private HashMap<Integer, int[]> num2coord;

    public int numberOfPatterns(int m, int n) {
        init();

        int res = 0;
        for(int k = m; k <= n; k++) {
            res += patternsFrom(1, new boolean[9], k) * 4;
            res += patternsFrom(2, new boolean[9], k) * 4;
            res += patternsFrom(5, new boolean[9], k);
        }
        return res;
    }

    private int patternsFrom(int num, boolean[] chosen, int remaining) {
        if(chosen[num - 1] || remaining == 0) return 0;
        if(remaining == 1) return 1;

        chosen[num - 1] = true;
        int sum = 0;
        int r = num2coord.get(num)[0];
        int c = num2coord.get(num)[1];
        for(int i = 1; i <= 9; i++) {
            if(i == num || chosen[i - 1]) continue;
            int nextR = num2coord.get(i)[0];
            int nextC = num2coord.get(i)[1];
            if(valid(num, i, chosen)) {
                sum += patternsFrom(i, chosen, remaining - 1);
            }
        }
        chosen[num - 1] = false;

        return sum;
    }

    private boolean valid(int cur, int next, boolean[] chosen) {
        if(Math.abs(cur - next) == 2 && num2coord.get(cur)[0] == num2coord.get(next)[0]) {
            return chosen[(cur + next) / 2 - 1];
        } else if(Math.abs(cur - next) == 6) {
            return chosen[Math.min(cur, next)  + 2];
        } else if(Math.abs(cur - next) == 8 || (Math.min(cur, next) == 3 && Math.max(cur, next) == 7)) {
            return chosen[(cur + next) / 2 - 1];
        } else return true;
    }

    private void init() {
        num2coord = new HashMap<>();
        for(int i = 1; i <= 9; i++) {
            int r = (i - 1) / 3;
            int c = (i - 1) % 3;
            num2coord.put(i, new int[]{r, c});
        }
    }
}
