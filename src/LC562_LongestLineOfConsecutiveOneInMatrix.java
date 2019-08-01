public class LC562_LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        if(M == null || M.length == 0) return 0;

        int m = M.length;
        int n = M[0].length;
        int longest = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] == 1) {
                    // check horizontal
                    if(j == 0 || M[i][j - 1] == 0) {
                        int k = j + 1;
                        while(k < n && M[i][k] == 1) k++;
                        longest = Math.max(longest, k - j);
                    }
                    // check vertical
                    if(i == 0 || M[i - 1][j] == 0) {
                        int k = i + 1;
                        while(k < m && M[k][j] == 1) k++;
                        longest = Math.max(longest, k - i);
                    }
                    // check diagonal
                    if(i == 0 || j == 0 || M[i - 1][j - 1] == 0) {
                        int len = 1;
                        while(i + len < m && j + len < n && M[i + len][j + len] == 1) len++;
                        longest = Math.max(longest, len);
                    }
                    // check anti-diagonal
                    if(i == 0 || j == n - 1 || M[i - 1][j + 1] == 0) {
                        int len = 1;
                        while(i + len < m && j - len >= 0 && M[i + len][j - len] == 1) len++;
                        longest = Math.max(longest, len);
                    }
                }
            }
        }

        return longest;
    }
}
