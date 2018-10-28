public class LC246_StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length()-1;
        while(i<=j){
            if(i==j) return num.charAt(i)=='0' || num.charAt(i)=='1' || num.charAt(i)=='8';
            if(num.charAt(i)=='0'){
                if(num.charAt(j)!='0') return false;
            }else if(num.charAt(i)=='1'){
                if(num.charAt(j)!='1') return false;
            }else if(num.charAt(i)=='8'){
                if(num.charAt(j)!='8') return false;
            }else if(num.charAt(i)=='6'){
                if(num.charAt(j)!='9') return false;
            }else if(num.charAt(i)=='9'){
                if(num.charAt(j)!='6') return false;
            }else return false;
            i++;
            j--;
        }
        return true;
    }
}
