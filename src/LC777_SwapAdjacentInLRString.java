public class LC777_SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if(start.length()!=end.length()) return false;
        int i = 0;
        int j = 0;
        while(i<start.length() && j<end.length()){
            while(i<start.length() && start.charAt(i)=='X') i++;
            while(j<end.length() && end.charAt(j)=='X') j++;
            if(i==start.length()) return j==end.length();
            if(j==end.length()) return i==start.length();
            if(start.charAt(i)!=end.charAt(j)) return false;
            else{
                if((start.charAt(i)=='L' && i<j) || (start.charAt(i)=='R' && i>j)) return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
