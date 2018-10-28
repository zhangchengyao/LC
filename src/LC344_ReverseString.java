public class LC344_ReverseString {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) sb.append(s.charAt(s.length()-1-i));
        return sb.toString();
    }
}
