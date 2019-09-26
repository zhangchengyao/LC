public class LC848_ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        int[] times = new int[S.length()];
        StringBuilder sb = new StringBuilder(S);
        for(int i = shifts.length - 1; i >= 0; i--) {
            if(i < shifts.length - 1) times[i] += times[i + 1];
            times[i] += shifts[i];
            times[i] %= 26;

            int shifted = sb.charAt(i) + times[i];
            if(shifted > (int)'z') shifted = (int)'a' + (shifted - (int)'z') - 1;
            sb.setCharAt(i, (char)(shifted));
        }

        return sb.toString();
    }
}
