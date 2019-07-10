public class LC161_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;

        int l1 = s.length();
        int l2 = t.length();
        if(Math.abs(l1 - l2) > 1) return false;

        int i = 0;
        int j = 0;
        while(i < l1 && j < l2) {
            if(s.charAt(i) != t.charAt(j)) {
                if(l1 == l2) {
                    return s.substring(i + 1).equals(t.substring(j + 1));
                } else if(l1 < l2) {
                    return s.substring(i).equals(t.substring(j + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(j));
                }
            }
            i++;
            j++;
        }

        return l1 != l2;
    }
}
