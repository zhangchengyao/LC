public class LC340_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k==0) return 0;

        int res = 0;
        int left = 0;
        int right = 0;
        int[] map = new int[256];
        int cnt = 0;
        while(right<s.length()){
            if(map[s.charAt(right)] == 0) cnt++;
            map[s.charAt(right)]++;
            while(cnt > k){
                map[s.charAt(left)]--;
                if(map[s.charAt(left)]==0) cnt--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
