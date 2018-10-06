public class LC91_DecodeWays {
    // dynamic programming
    public int numDecodings(String s) {
        if(s.length()==0) return 1;
        if(s.length()==1){
            if(s.charAt(0)=='0') return 0;
            else return 1;
        }
        if(s.charAt(0)=='0') return 0;
        char[] str = s.toCharArray();
        int[] dp = new int[str.length+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            int j = i-1;
            if(str[j]=='0'){
                if(str[j-1]=='0' || str[j-1]>'2') return 0;
                else dp[i] = dp[i-2];
            }
            else if(str[j]>'6'){
                if(str[j-1]=='1') dp[i] = dp[i-1]+dp[i-2];
                else dp[i] = dp[i-1];
            }
            else{
                if(str[j-1]=='1' || str[j-1]=='2') dp[i] = dp[i-1]+dp[i-2];
                else dp[i] = dp[i-1];
            }
        }
        return dp[str.length];
    }
    // recusive solution
//    public int numDecodings(String s) {
//        return decode(s, 0);
//    }
//    private int decode(String s, int start){
//        if(start==s.length()) return 1;
//        if(start==s.length()-1){
//            if(s.charAt(start)=='0') return 0;
//            else return 1;
//        }
//        char c = s.charAt(start);
//        if(c=='0') return 0;
//        else if(c=='1'){
//            if(s.charAt(start+1)=='0') return decode(s, start+2);
//            else return decode(s, start+1)+decode(s, start+2);
//        }
//        else if(c=='2'){
//            if(s.charAt(start+1)=='0') return decode(s, start+2);
//            else if(s.charAt(start+1)<='6') return decode(s, start+1)+decode(s, start+2);
//            else return decode(s, start+1);
//        }
//        else{
//            if(s.charAt(start+1)=='0') return 0;
//            else return decode(s, start+1);
//        }
//    }
}
