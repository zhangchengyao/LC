public class LC214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0;
        int end = s.length()-1;
        int j = end;
        char[] arr = s.toCharArray();
        while(i<j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }else{
                i = 0;
                end--;
                j = end;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(end+1));
        return sb.reverse().append(s).toString();
    }
}
