public class LC7_ReverseInteger {
    public int reverse(int x) {
        String s = x+"";
        long res = 0;
        if(s.charAt(0)=='-') s = s.substring(1);
        int num = s.length();
        for(int i=num-1;i>=0;i--){
            res += Math.pow(10, i)*(s.charAt(i)-'0');
        }
        if(x<0) res = -res;
        return res<Integer.MIN_VALUE||res>Integer.MAX_VALUE?0:(int)res;
    }
}
