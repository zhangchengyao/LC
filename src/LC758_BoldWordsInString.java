public class LC758_BoldWordsInString {
    public String boldWords(String[] words, String S) {
        boolean[] bold = new boolean[S.length()];
        for(String word: words) {
            int len = word.length();
            int fromIdx = 0;
            while(true) {
                int idx = S.indexOf(word, fromIdx);
                if(idx < 0) break;
                for(int j = idx; j < idx + len; j++) {
                    bold[j] = true;
                }
                fromIdx = idx + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bold.length; i++) {
            if(!bold[i]) {
                sb.append(S.charAt(i));
            } else {
                int j = i + 1;
                while(j < bold.length && bold[j]) {
                    j++;
                }
                sb.append("<b>").append(S, i, j).append("</b>");
                i = j - 1;
            }
        }

        return sb.toString();
    }
}
