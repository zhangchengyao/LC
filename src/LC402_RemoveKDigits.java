public class LC402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        String res = removeRec(num, k);
        int i = 0;
        while(i<res.length() && res.charAt(i)=='0') i++;
        res = res.substring(i);
        return res.equals("")?"0":res;
    }
    private String removeRec(String num, int k){
        if(k>=num.length()) return "";
        if(k==0) return num;
        int minIndex = 0;
        for(int i=1;i<=k;i++){
            if(num.charAt(i)<num.charAt(minIndex)) minIndex = i;
        }
        return num.charAt(minIndex)+removeRec(num.substring(minIndex+1), k-minIndex);
    }
}
