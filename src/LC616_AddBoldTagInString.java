public class LC616_AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for(String word: dict) {
            int len = word.length();
            for(int i = 0; i <= s.length() - len; i++) {
                if(s.substring(i, i + len).equals(word)) {
                    for(int k = i; k < i + len; k++) {
                        bold[k] = true;
                    }
                }
            }
        }

        int i = 0;
        int j;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()) {
            if(bold[i]) {
                j = i + 1;
                while(j < s.length() && bold[j]) j++;
                sb.append("<b>").append(s, i, j).append("</b>");
                i = j;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
