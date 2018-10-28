import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC438_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[256];
        for(int i=0;i<p.length();i++) map[p.charAt(i)]++;
        int l = 0;
        int r = 0;
        int cnt = p.length();
        while(r<s.length()){
            map[s.charAt(r)]--;
            if(map[s.charAt(r)]>=0) cnt--;
            if(cnt==0) res.add(l);
            if(r-l==p.length()-1){
                if(map[s.charAt(l)]>=0) cnt++;
                map[s.charAt(l)]++;
                l++;
            }
            r++;
        }
        return res;
    }
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//        if(s.length()==0||p.length()==0||s.length()<p.length()) return res;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(int i=0;i<p.length();i++){
//            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
//        }
//        HashMap<Character, Integer> tmp = new HashMap<>();
//        for(int i=0;i<p.length();i++){
//            tmp.put(s.charAt(i), tmp.getOrDefault(s.charAt(i), 0)+1);
//        }
//        if(tmp.equals(map)) res.add(0);
//        for(int i=1;i<=s.length()-p.length();i++){
//            tmp.put(s.charAt(i-1), tmp.getOrDefault(s.charAt(i-1), 0)-1);
//            if(tmp.get(s.charAt(i-1))==0) tmp.remove(s.charAt(i-1));
//            tmp.put(s.charAt(i+p.length()-1), tmp.getOrDefault(s.charAt(i+p.length()-1), 0)+1);
//            if(tmp.equals(map)) res.add(i);
//        }
//        return res;
//    }
}
