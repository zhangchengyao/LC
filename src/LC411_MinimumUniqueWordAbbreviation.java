public class LC411_MinimumUniqueWordAbbreviation {
    public String minAbbreviation(String target, String[] dictionary) {
        int m = target.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for(int i = 1; i <= (1 << m); i++){
            int len = abbrLen(target, i);
            if(len >= minLen) continue;
            boolean conflict = false;
            for(String word: dictionary){
                if(word.length() != m) continue;
                if(hasConflict(target, word, i)){
                    conflict = true;
                    break;
                }
            }
            if(!conflict){
                minLen = len;
                res = getAbbr(target, i);
            }
        }
        return res;
    }
    private int abbrLen(String target, int bVal){
        int m = target.length();
        int len = 0;
        for(int i = 0; i < m; i++){
            if((bVal >> i & 1) == 1) len++;
            else{
                if((bVal >> (i+1) & 1) == 1 || i == m-1) len++;
            }
        }
        return len;
    }
    private boolean hasConflict(String target, String word, int bVal){
        int m = target.length();
        for(int i = 0; i < m; i++){
            if((bVal >> i & 1) == 1){
                if(target.charAt(m - 1 - i) != word.charAt(m - 1 - i)) return false;
            }
        }
        return true;
    }
    private String getAbbr(String target, int bVal){
        StringBuilder sb = new StringBuilder();
        int m = target.length();
        int numZero = 0;
        for(int i = 0; i < m; i++){
            if((bVal >> i & 1) == 1){
                if(numZero != 0) sb.insert(0, numZero);
                sb.insert(0, target.charAt(m - 1 - i));
                numZero = 0;
            }
            else{
                numZero++;
            }
        }
        if(numZero != 0) sb.insert(0, numZero);
        return sb.toString();
    }
}
