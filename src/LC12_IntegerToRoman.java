public class LC12_IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] input = (num+"").toCharArray();
        for(int p=input.length-1;p>=0;p--){
            int val = input[p]-'0';
            int pos = input.length-1-p;
            if(pos==0){
                if(val<4){
                    for(int i=0;i<val;i++) sb.insert(0, "I");
                }
                else if(val==4) sb.insert(0, "IV");
                else if(val<9){
                    for(int i=0;i<val-5;i++) sb.insert(0, "I");
                    sb.insert(0, "V");
                }
                else sb.insert(0, "IX");
            }else if(pos==1){
                if(val<4){
                    for(int i=0;i<val;i++) sb.insert(0, "X");
                }
                else if(val==4) sb.insert(0, "XL");
                else if(val<9){
                    for(int i=0;i<val-5;i++) sb.insert(0, "X");
                    sb.insert(0, "L");
                }
                else sb.insert(0, "XC");
            }else if(pos==2){
                if(val<4){
                    for(int i=0;i<val;i++) sb.insert(0, "C");
                }
                else if(val==4) sb.insert(0, "CD");
                else if(val<9){
                    for(int i=0;i<val-5;i++) sb.insert(0, "C");
                    sb.insert(0, "D");
                }
                else sb.insert(0, "CM");
            }else{
                for(int i=0;i<val;i++){
                    sb.insert(0, "M");
                }
            }
        }
        return sb.toString();
    }
}
