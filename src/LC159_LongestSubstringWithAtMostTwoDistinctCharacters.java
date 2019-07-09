public class LC159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int numDiff = 0;
        while(right < s.length()) {
            if(count[s.charAt(right)] == 0) {
                numDiff++;
            }
            count[s.charAt(right++)]++;
            while(numDiff > 2) {
                if(count[s.charAt(left)] == 1) numDiff--;
                count[s.charAt(left++)]--;
            }
            maxLength = Math.max(maxLength, right - left);
        }

        return Math.max(maxLength, right - left);
    }
}
