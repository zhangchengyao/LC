public class LC1119_RemoveVowelsFromAString {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()) {
            if(isNotVowel(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean isNotVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
    }
}
