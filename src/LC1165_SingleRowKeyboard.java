public class LC1165_SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        int[] char2index = new int[26];
        for(int i = 0; i < keyboard.length(); i++) {
            char2index[keyboard.charAt(i) - 'a'] = i;
        }

        int time = 0;
        int cur = 0;
        for(char c: word.toCharArray()) {
            time += Math.abs(char2index[c - 'a'] - cur);
            cur = char2index[c - 'a'];
        }

        return time;
    }
}
