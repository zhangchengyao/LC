public class LC9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        long res = 0;
        String s = x+"";
        for(int i=s.length()-1;i>=0;i--){
            res += Math.pow(10, i)*(s.charAt(i)-'0');
        }
        return (int)res==x;
    }
}
