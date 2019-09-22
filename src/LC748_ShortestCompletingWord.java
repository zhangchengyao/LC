import java.util.Arrays;

public class LC748_ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] count = new int[26];
        int size = 0;
        for(char c: licensePlate.toCharArray()) {
            if(Character.isLetter(c)) {
                count[c - 'a']++;
                if(count[c - 'a'] == 1) size++;
            }
        }

        String res = "";
        for(String word: words) {
            int[] copy = Arrays.copyOf(count, 26);
            int cnt = size;
            for(char c: word.toCharArray()) {
                copy[c - 'a']--;
                if(copy[c - 'a'] == 0) cnt--;
            }
            if(cnt == 0) {
                if(res.equals("") || word.length() < res.length()) res = word;
            }
        }

        return res;
    }
}
