public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        int start = 0;
        int end = 1;
        int max = 0;
        while(end<s.length()){
            int index = s.substring(start, end).indexOf(s.charAt(end));
            if(index!=-1){
                if(end-start>max) max = end-start;
                start = start+index+1;
            }
            end++;
        }
        return Math.max(max, end-start);
    }
}
