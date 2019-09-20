import java.util.HashSet;
import java.util.Stack;

public class LC316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        HashSet<Character> added = new HashSet<>();
        for(char c: s.toCharArray()) {
            count[c - 'a']--;
            if(added.contains(c)) continue;

            if(!stack.isEmpty() && c < stack.peek()) {
                while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                    added.remove(stack.pop());
                }
            }

            stack.push(c);
            added.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
