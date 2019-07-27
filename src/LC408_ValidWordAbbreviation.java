public class LC408_ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null) return false;

        int match = 0;
        int i = 0;
        while(match < word.length() && i < abbr.length()) {
            if(abbr.charAt(i) > '9') {
                if(abbr.charAt(i++) != word.charAt(match++)) return false;
            } else if(abbr.charAt(i) == '0') {
                return false;
            } else {
                int j = i + 1;
                while(j < abbr.length() && abbr.charAt(j) <= '9') j++;

                int len = Integer.parseInt(abbr.substring(i, j));
                if(match + len > word.length()) return false;
                match += len;
                i = j;
            }
        }

        return match >= word.length() && i >= abbr.length();
    }
}
