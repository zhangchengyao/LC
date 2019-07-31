public class LC555_SplitConcatenatedStrings {
    public String splitLoopedString(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            String rev = new StringBuilder(str).reverse().toString();
            sb.append(str.compareTo(rev) > 0 ? str : rev);
        }

        String concat = sb.toString();
        String res = "a";
        int cur = 0;
        for(String str: strs) {
            String mid = concat.substring(cur + str.length()) + concat.substring(0, cur);
            String rev = new StringBuilder(str).reverse().toString();
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= res.charAt(0)) {
                    String tmp = str.substring(i) + mid + str.substring(0, i);
                    if(tmp.compareTo(res) > 0) res = tmp;
                }
                if(rev.charAt(i) >= res.charAt(0)) {
                    String tmp = rev.substring(i) + mid + rev.substring(0, i);
                    if(tmp.compareTo(res) > 0) res = tmp;
                }
            }

            cur += str.length();
        }
        return res;
    }
}
