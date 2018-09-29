public class LC67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder s1 = new StringBuilder(a);
        StringBuilder s2 = new StringBuilder(b);
        if(s1.length()<s2.length()) while(s1.length()<s2.length()) s1.insert(0, "0");
        if(s2.length()<s1.length()) while(s2.length()<s1.length()) s2.insert(0, "0");
        int len = s1.length();
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for(int i=0;i<len;i++){
            int tmp = (s1.charAt(len-i-1)-'0')+(s2.charAt(len-i-1)-'0')+carry;
            carry = tmp/2;
            res.insert(0, tmp%2);
        }
        if(carry>0) res.insert(0, carry);
        return res.toString();
    }
}
