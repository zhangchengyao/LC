public class LC557_ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            for(int j=words[i].length()-1;j>=0;j--) sb.append(words[i].charAt(j));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
