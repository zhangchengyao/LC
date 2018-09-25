public class LC387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[][] chars = new int[2][26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            chars[0][c-'a'] += 1;
            if(chars[0][c-'a']==1) chars[1][c-'a'] = i;
        }
        int min = s.length();
        for(int i=0;i<chars[0].length;i++){
            if(chars[0][i]==1) min = Math.min(min, chars[1][i]);
        }
        return min==s.length()?-1:min;
    }
}
