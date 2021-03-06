public class LC248_StrobogrammaticNumberIII {
    private char[] numbers = new char[]{'0', '1', '6', '8', '9'};
    private int res = 0;
    public int strobogrammaticInRange(String low, String high) {
        for(int len = low.length(); len <= high.length(); len++){
            construct("", len, low, high);
        }
        return res;
    }
    private void construct(String str, int len, String low, String high){
        if(str.length() == len) {
            if(str.length() == low.length()) {
                if(str.compareTo(low) >= 0 && (str.length() < high.length() || str.compareTo(high) <= 0)) res++;
            } else if(str.length() == high.length()) {
                if(str.compareTo(high) <= 0 && (str.length() > low.length() || str.compareTo(low) >= 0)) res++;
            } else {
                res++;
            }
            return;
        }

        for(char c: numbers){
            if((c == '0' && str.length() == 0 && len != 1) || (c == '6' || c== '9') && str.length() == len-1) continue;
            StringBuilder sb = new StringBuilder(str);
            int pos = str.length()/2;
            if(c == '6'){
                sb.insert(pos, "69");
                construct(sb.toString(), len, low, high);
            }
            else if(c == '9'){
                sb.insert(pos, "96");
                construct(sb.toString(), len, low, high);
            }
            else{
                if(str.length() == len - 1) sb.insert(pos, c);
                else sb.insert(pos, c+""+c);
                construct(sb.toString(), len, low, high);
            }
        }
    }
}
