public class LC1056_ConfusingNumber {
    public boolean confusingNumber(int N) {
        String s = Integer.toString(N);
        int i = 0;
        int j = s.length() - 1;
        boolean diff = false;
        while(i < j) {
            if(inValid(s, i) || inValid(s, j)) return false;
            if(!(s.charAt(i) == s.charAt(j) || (s.charAt(i) == '6' && s.charAt(j) == '9') || (s.charAt(i) == '9' && s.charAt(j) == '6'))) diff = true;
            i++;
            j--;
        }

        if(i == j) {
            if(inValid(s, i)) return false;
            diff |= s.charAt(i) == '6' || s.charAt(i) == '9';
        }

        return diff;
    }

    private boolean inValid(String s, int i) {
        char c = s.charAt(i);
        return c != '0' && c != '1' && c != '6' && c != '8' && c != '9';
    }
}