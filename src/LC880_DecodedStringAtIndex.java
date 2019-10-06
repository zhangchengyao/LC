public class LC880_DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        long len = 0;
        for(char c: S.toCharArray()) {
            if(Character.isLetter(c)) {
                len++;
            } else {
                len *= c - '0';
            }
        }

        for(int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            K %= len;
            if(K == 0 && Character.isLetter(c)) return Character.toString(c);

            if(Character.isLetter(c)) {
                len--;
            } else {
                len /= c - '0';
            }
        }

        return null;
    }
}
