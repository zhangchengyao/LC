public class LC859_BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;

        if(A.equals(B)) {
            int[] count = new int[26];
            for(char c: A.toCharArray()) {
                count[c - 'a']++;
                if(count[c - 'a'] > 1) return true;
            }
            return false;
        }

        int diff1 = -1;
        int diff2 = -1;
        int cnt = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt(i)) {
                if(diff1 == -1) {
                    diff1 = i;
                } else {
                    diff2 = i;
                }
                cnt++;
                if(cnt > 2) return false;
            }
        }

        if(cnt == 2) {
            return A.charAt(diff1) == B.charAt(diff2) && A.charAt(diff2) == B.charAt(diff1);
        } else {
            return false;
        }
    }
}
