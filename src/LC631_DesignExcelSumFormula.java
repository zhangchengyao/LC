import java.util.HashMap;

public class LC631_DesignExcelSumFormula {
    private int[][] form;
    private HashMap<String, String[]> sumMap;

    public LC631_DesignExcelSumFormula(int H, char W) {
        form = new int[H][W - 'A' + 1];
        sumMap = new HashMap<>();
    }

    public void set(int r, char c, int v) {
        String pos = c + Integer.toString(r);
        sumMap.remove(pos);
        form[r - 1][c - 'A'] = v;
    }

    public int get(int r, char c) {
        String pos = c + Integer.toString(r);
        if(sumMap.containsKey(pos)) {
            return sum(r, c, sumMap.get(pos));
        }
        return form[r - 1][c - 'A'];
    }

    public int sum(int r, char c, String[] strs) {
        int sum = 0;
        String sumPos = c + Integer.toString(r);
        for(String str: strs) {
            if(!str.contains(":")) {
                sum += get(Integer.parseInt(str.substring(1)), str.charAt(0));
            } else {
                String topLeft = str.split(":")[0];
                String botRight = str.split(":")[1];
                int[] topLeftPos = getCoord(topLeft);
                int[] botRightPos = getCoord(botRight);
                for(int i = topLeftPos[0]; i <= botRightPos[0]; i++) {
                    for(int j = topLeftPos[1]; j <= botRightPos[1]; j++) {
                        sum += get(i, (char)(j + 'A'));
                    }
                }
            }
        }
        sumMap.put(sumPos, strs);
        return sum;
    }

    private int[] getCoord(String str) {
        return new int[]{Integer.parseInt(str.substring(1)), str.charAt(0) - 'A'};
    }
}
