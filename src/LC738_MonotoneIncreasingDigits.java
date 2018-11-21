public class LC738_MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        StringBuilder sb = new StringBuilder(N+"");
        int j = sb.length();
        for(int i=sb.length()-1;i>0;i--){
            if(sb.charAt(i)<sb.charAt(i-1)) {
                sb.setCharAt(i-1, (char)(sb.charAt(i-1)-1));
                j = i-1;
            }
        }
        for(int i=j+1;i<sb.length();i++) sb.setCharAt(i, '9');
        if(sb.charAt(0)=='0') sb.deleteCharAt(0);
        return Integer.parseInt(sb.toString());
    }
}
