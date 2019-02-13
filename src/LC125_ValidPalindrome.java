public class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))){
                i++;
            } else if(!Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))){
                j--;
            } else {
                if(s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
        }

        return true;
    }
}
