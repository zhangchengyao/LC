public class LC424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int major = -1;
        int[] map = new int[26];
        int i = 0;
        int j = 0;
        while(j<s.length()){
            int index = s.charAt(j)-'A';
            map[index]++;
            if(map[index]>major) major = map[index];
            int others = j-i+1-major;
            if(others>k){
                res = Math.max(res, j-i);
                while(others>k){
                    map[s.charAt(i)-'A']--;
                    for (int a : map) {
                        if (a > major) major = a;
                    }
                    i++;
                    others = j-i+1-major;
                }
            }
            j++;
        }
        return Math.max(j-i, res);
    }
}
