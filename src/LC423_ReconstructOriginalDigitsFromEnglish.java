public class LC423_ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        // number of 'z' = num[0];
        // number of 'w' = num[2];
        // number of 'u' = num[4];
        // number of 'x' = num[6];
        // number of 'g' = num[8];
        // number of 'o' -num[0]-num[2]-num[4] = num[1];
        // number of 'r' -num[0]-num[4] = num[3];
        // number of 'f' -num[4] = num[5];
        // number of 'v' -num[5] = num[7];
        // number of 'i' -num[5]-num[6]-num[8] = num[9];
        int[] num = new int[10];
        int[] letters = new int[26];
        for(int i=0;i<s.length();i++){
            letters[s.charAt(i)-'a']++;
        }
        num[0] = letters['z'-'a'];
        num[2] = letters['w'-'a'];
        num[4] = letters['u'-'a'];
        num[6] = letters['x'-'a'];
        num[8] = letters['g'-'a'];
        num[1] = letters['o'-'a']-num[0]-num[2]-num[4];
        num[3] = letters['r'-'a']-num[0]-num[4];
        num[5] = letters['f'-'a']-num[4];
        num[7] = letters['v'-'a']-num[5];
        num[9] = letters['i'-'a']-num[5]-num[6]-num[8];
        StringBuilder res = new StringBuilder();
        for(int i=0;i<10;i++){
            for(int j=0;j<num[i];j++) res.append(i);
        }
        return res.toString();
    }
}
