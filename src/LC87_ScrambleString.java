import java.util.HashMap;

public class LC87_ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;

        boolean res;

        for(int i=1;i<s1.length();i++){
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);
            String s2Left = s2.substring(0, i);
            String s2Right = s2.substring(i);
            if(isAnagram(s1Left, s2Left) && isAnagram(s1Right, s2Right)){
                res = isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right);
                if(res) return true;
            }

            s2Left = s2.substring(0, s2.length()-i);
            s2Right = s2.substring(s2.length()-i);
            if(isAnagram(s1Left, s2Right) && isAnagram(s1Right, s2Left)){
                res = isScramble(s1Left, s2Right) && isScramble(s1Right, s2Left);
                if(res) return true;
            }
        }

        return false;
    }

    private boolean isAnagram(String s1, String s2){
        if(s1.length()!=s2.length()) return false;

        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c: s1.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        for(char c: s2.toCharArray()){
            if(!freq.containsKey(c)) return false;
            freq.put(c, freq.get(c)-1);
            if(freq.get(c)==0) freq.remove(c);
        }

        return freq.size()==0;
    }
}
