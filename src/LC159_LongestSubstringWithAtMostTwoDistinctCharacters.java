public class LC159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[256];
        int cnt = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<s.length()){
            if(map[s.charAt(right++)]++==0) cnt++;
            if(cnt>2){
                while(cnt>2){
                    if(map[s.charAt(left)]--==1) cnt--;
                    left++;
                }
            }
            if(cnt==2) res = Math.max(res, right-left);
        }
        res = Math.max(res, right-left);
        return res;
    }
}
