public class LC844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while(i >= 0 || j >= 0) {
            while(i >= 0 && (skipS > 0 || S.charAt(i) == '#')) {
                if(S.charAt(i) == '#') skipS++;
                else skipS--;
                i--;
            }
            while(j >= 0 && (skipT > 0 || T.charAt(j) == '#')) {
                if(T.charAt(j) == '#') skipT++;
                else skipT--;
                j--;
            }

            if(i < 0 && j < 0) return true;
            else if(i < 0 || j < 0) return false;

            if(S.charAt(i--) != T.charAt(j--)) return false;
        }

        return true;
    }
}
