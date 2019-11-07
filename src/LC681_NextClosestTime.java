import java.util.TreeSet;

public class LC681_NextClosestTime {
    public String nextClosestTime(String time) {
        char[] digits = new char[]{time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        TreeSet<Character> set = new TreeSet<>();
        for(char c: digits) set.add(c);

        for(int i = digits.length - 1; i >= 0; i--) {
            if(set.higher(digits[i]) != null){
                char c = set.higher(digits[i]);
                if(i == 2 && c >= '6') continue;
                if(i == 1 && time.charAt(0) == '2' && c >= '4') continue;
                if(i == 0 && c >= '3') continue;
                StringBuilder res = new StringBuilder(time);
                if(i > 1) {
                    res.setCharAt(++i, c);
                    while(++i < time.length()) res.setCharAt(i, set.first());
                } else {
                    res.setCharAt(i, c);
                    while(++i < time.length())
                        if(time.charAt(i) != ':')
                            res.setCharAt(i, set.first());
                }
                return res.toString();
            }
        }
        char c = set.first();
        return String.format("%c%c:%c%c", c, c, c, c);
    }
}
