public class LC520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(isCapital(word.charAt(0)) ){
            return word.toUpperCase().equals(word) || word.substring(1).toLowerCase().equals(word.substring(1));
        } else {
            return word.toLowerCase().equals(word);
        }
    }

    private boolean isCapital(char c){
        return c>='A' && c<='Z';
    }
}
