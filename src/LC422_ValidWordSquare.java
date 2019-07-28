import java.util.HashMap;
import java.util.List;

public class LC422_ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0) return true;

        HashMap<Integer, String> map = new HashMap<>();
        int j = 0;
        boolean finish = false;
        while(!finish) {
            finish = true;
            StringBuilder sb = new StringBuilder();
            for(String word: words) {
                if(j < word.length()) {
                    sb.append(word.charAt(j));
                    finish = false;
                }
            }
            map.put(j, sb.toString());
            j++;
        }

        for(int i = 0; i < words.size(); i++) {
            if(!words.get(i).equals(map.get(i))) return false;
        }

        return true;
    }
}
