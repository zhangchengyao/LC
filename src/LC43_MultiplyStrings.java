public class LC43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int[] digits = new int[num1.length()+num2.length()-1];
        int carry = 0;
        int hc;
        for(int i=0;i<num1.length();i++){
            hc = carry;
            carry = 0;
            for(int j=0;j<num2.length();j++){
                int tmp = (num1.charAt(num1.length()-1-i)-'0')*(num2.charAt(num2.length()-1-j)-'0')+carry;
                if(j==num2.length()-1) tmp += hc;
                digits[i+j] += tmp;
                carry = digits[i+j]/10;
                digits[i+j] %= 10;
            }
        }
        for(int i=0;i<digits.length;i++){
            sb.insert(0, digits[i]);
        }
        if(carry>0) sb.insert(0, carry);
        else{
            int k = 0;
            while(k<sb.length() && sb.charAt(k)=='0') k++;
            if(k==sb.length()) sb = new StringBuilder("0");
            else sb = new StringBuilder(sb.substring(k));
        }
        return sb.toString();
    }
}
