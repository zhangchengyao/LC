public class LC395_LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if(s==null || s.length()==0) return 0;
        if(k<=1) return s.length();

        int[] map = new int[26];
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            map[idx]++;
        }

        int index = 0;
        int maxLen = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(map[s.charAt(i)-'a']<k){
                int len = longestSubstring(s.substring(index, i), k);
                maxLen = Math.max(maxLen, len);

                for(int j=index;j<=i;j++){
                    int idx = s.charAt(j)-'a';
                    map[idx]--;
                }
                index = i+1;
                count = 0;
            } else {
                count++;
            }
        }

        maxLen = Math.max(maxLen, count);
        return maxLen;
    }
}
