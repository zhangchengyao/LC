public class LC796_RotateString {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.equals("")) return true;

        for(int i = 0; i < A.length(); i++) {
            if((A + A).substring(i, A.length() + i).equals(B)) return true;
        }

        return false;
    }
}
