import java.util.HashMap;

public class LC533_LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;

        int n = picture[0].length;

        int[] colCnt = new int[n];
        HashMap<String, Integer> pattern = new HashMap<>();

        for (char[] chars : picture) {
            int rowCnt = 0;
            for (int j = 0; j < n; j++) {
                if (chars[j] == 'B') {
                    rowCnt++;
                    colCnt[j]++;
                }
            }

            if (rowCnt == N) {
                String row = new String(chars);
                pattern.put(row, pattern.getOrDefault(row, 0) + 1);
            }
        }

        int res = 0;
        for(String row: pattern.keySet()) {
            if(pattern.get(row) == N) {
                for(int j = 0; j < n; j++) {
                    if(row.charAt(j) == 'B' && colCnt[j] == N) {
                        res += N;
                    }
                }
            }
        }

        return res;
    }
}