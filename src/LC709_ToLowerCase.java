public class LC709_ToLowerCase {
    public String toLowerCase(String str) {
        int diff = 'a' - 'A';
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                sb.setCharAt(i, (char)(c + diff));
            }
        }

        return sb.toString();
    }
}
