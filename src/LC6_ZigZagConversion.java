public class LC6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s.equals("") || numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        int interval = numRows*2-2;
        for(int i=0;i<s.length();i+=interval){
            sb.append(s.charAt(i));
        }
        for(int r = 1;r<numRows-1;r++){
            interval = r*2;
            for(int i=r;i<s.length();i+=interval){
                interval = numRows*2-2-interval;
                sb.append(s.charAt(i));
            }
        }
        interval = numRows*2-2;
        for(int i=numRows-1;i<s.length();i+=interval){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
