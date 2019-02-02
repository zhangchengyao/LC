public class LC567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        for(char c: s1.toCharArray()) {
            s1Count[c-'a']++;
        }

        int l = 0;
        int r = 0;
        while(r < s2.length()){
            int idx = s2.charAt(r++)-'a';
            s1Count[idx]--;
            while(s1Count[idx] < 0) s1Count[s2.charAt(l++)-'a']++;
            if(r - l == s1.length()) return true;
        }

        return false;
    }
}
