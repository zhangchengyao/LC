import java.util.Arrays;

public class LC415_AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        StringBuilder n1 = null;
        StringBuilder n2 = null;
        if(num1.length()<num2.length()){
            n1 = new StringBuilder(num2);
            n2 = new StringBuilder(num1);
        }else{
            n1 = new StringBuilder(num1);
            n2 = new StringBuilder(num2);
        }
        int diff = n1.length()-n2.length();
        for(int i=0;i<diff;i++){
            n2.insert(0, "0");
        }
        int sum;
        int carry = 0;
        for(int i=n1.length()-1;i>=0;i--){
            sum = (n1.charAt(i)-'0') + (n2.charAt(i)-'0') + carry;
            if(sum<10) carry = 0;
            else carry = 1;
            res.insert(0, sum%10);
        }
        if(carry==1) res.insert(0, "1");
        return res.toString();
    }
}
