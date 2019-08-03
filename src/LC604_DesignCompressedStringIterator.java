public class LC604_DesignCompressedStringIterator {
    private char[] letters;
    private int[] cnts;
    private int cur;
    private int num;

    public LC604_DesignCompressedStringIterator(String compressedString) {
        letters = new char[compressedString.length() / 2];
        cnts = new int[letters.length];
        cur = 0;

        int i = 0;
        int j;
        int idx = 0;
        while(i < compressedString.length()) {
            if(Character.isLetter(compressedString.charAt(i))) {
                letters[idx] = compressedString.charAt(i);
                i++;
            } else {
                j = i + 1;
                while(j < compressedString.length() && Character.isDigit(compressedString.charAt(j))) j++;
                cnts[idx++] = Integer.parseInt(compressedString.substring(i, j));
                i = j;
            }
        }

        num = idx;
    }

    public char next() {
        if(hasNext()) {
            char res = letters[cur];
            cnts[cur]--;
            if(cnts[cur] == 0) cur++;
            return res;
        } else {
            return ' ';
        }
    }

    public boolean hasNext() {
        return cur < num;
    }
}
