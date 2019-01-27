package amazon;

public class LongestPalindromeSubstring {
    // same with LC5
//    public static String longestPalindromeSubstring(String input){
//        if(input==null || input.equals("")) return "";
//
//        int maxLen = 0;
//        String res = "";
//        for(int i=0;i<input.length();i++){
//            int l = i;
//            int r = i;
//            while(l>=0 && input.charAt(l)==input.charAt(i)) l--;
//            while(r<input.length() && input.charAt(r)==input.charAt(i)) r++;
//
//            while(l>=0 && r<input.length() && input.charAt(l)==input.charAt(r)){
//                l--;
//                r++;
//            }
//
//            if(r-l-1>maxLen){
//                maxLen = r-l-1;
//                res = input.substring(l+1, r);
//            }
//        }
//
//        return res;
//    }
}
