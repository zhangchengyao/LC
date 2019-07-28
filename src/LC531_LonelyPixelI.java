public class LC531_LonelyPixelI {
    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;

        int m = picture.length;
        int n = picture[0].length;

        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B') {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B' && rowCnt[i] == 1 && colCnt[j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
