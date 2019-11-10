import java.util.Arrays;

public class LC691_StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        int n = 1 << target.length();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;

            for(String sticker: stickers) {
                int cur = i;
                for(char c: sticker.toCharArray()) {
                    for(int k = 0; k < target.length(); k++) {
                        if(target.charAt(k) == c && ((cur >>> k) & 1) == 0) {
                            cur |= 1 << k;
                            break;
                        }
                    }
                }
                dp[cur] = Math.min(dp[cur], dp[i] + 1);
            }
        }

        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}
