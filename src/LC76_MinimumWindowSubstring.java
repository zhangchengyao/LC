import java.util.HashMap;

public class LC76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.equals("") || s.length()<t.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        int left = 0;
        int right = 0;
        int numOfZero = 0;
        int minLen = s.length()+1;
        int resLeft = left;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right))==0) numOfZero++;
                while(true){
                    if(map.containsKey(s.charAt(left))){
                        if(map.get(s.charAt(left))<0) map.put(s.charAt(left), map.get(s.charAt(left))+1);
                        else break;
                    }
                    left++;
                }
                if(numOfZero==map.size() && right-left+1<minLen){
                    minLen = right-left+1;
                    resLeft = left;
                }
            }
            right++;
        }
        return numOfZero==map.size()?s.substring(resLeft, resLeft+minLen):"";
    }
}
