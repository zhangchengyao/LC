public class LC8_StringToIntegerAtoi {
    public int myAtoi(String str) {
        str = str.trim();

        int i = 0;
        if(i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) i++;
        while(i < str.length() && Character.isDigit(str.charAt(i))) i++;
        if(i == 0 || ((str.charAt(0) == '-' || str.charAt(0) == '+') && i == 1)) return 0;

        // eliminating leading zeros
        int j = str.charAt(0) == '+' || str.charAt(0) == '-' ? 1 : 0;
        while(j < str.length() && str.charAt(j) == '0') j++;
        if(j == str.length() || j >= i) return 0;

        String min = String.valueOf(Integer.MIN_VALUE);
        String max = String.valueOf(Integer.MAX_VALUE);
        String val = str.substring(j, i);
        if(str.charAt(0) == '-') val = "-" + val;

        if(val.charAt(0) == '-'){
            if(val.length() > min.length() ||
                    (val.length() == min.length() && val.compareTo(min) > 0)){
                return Integer.MIN_VALUE;
            }
        } else {
            if(val.length() > max.length() ||
                    (val.length() == max.length() && val.compareTo(max) > 0)){
                return Integer.MAX_VALUE;
            }
        }
        return Integer.parseInt(val);
    }
}
