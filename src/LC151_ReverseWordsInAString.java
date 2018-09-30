public class LC151_ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            if(!words[i].equals("")){
                sb.append(words[i]+" ");
            }
        }
        return sb.toString().trim();
    }
}
