public class LC246_StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length()-1;
        while(i <= j){
            boolean is018 = num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8';
            if(i == j) return is018;
            if(is018) {
                if(num.charAt(i) != num.charAt(j)) return false;
            } else if(num.charAt(i) == '6') {
                if(num.charAt(j) != '9') return false;
            } else if(num.charAt(i) == '9') {
                if(num.charAt(j) != '6') return false;
            } else {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
