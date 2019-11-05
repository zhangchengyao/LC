public class LC953_VerifyingAnAlienDictionary {
    private int[] priority = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < order.length(); i++) {
            priority[order.charAt(i) - 'a'] = i;
        }

        for(int i = 1; i < words.length; i++) {
            if(larger(words[i - 1], words[i])) return false;
        }

        return true;
    }

    private boolean larger(String a, String b) {
        for(int i = 0; i < Math.min(a.length(), b.length()); i++) {
            int idxa = a.charAt(i) - 'a';
            int idxb = b.charAt(i) - 'a';
            if(priority[idxa] > priority[idxb]) return true;
            else if(priority[idxa] < priority[idxb]) return false;
        }

        return a.length() > b.length();
    }
}
