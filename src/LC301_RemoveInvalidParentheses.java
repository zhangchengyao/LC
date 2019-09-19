import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC301_RemoveInvalidParentheses {
    private int longest = 0;
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        helper(s, new StringBuilder(), res, 0, 0, 0, new HashSet<>());

        return res;
    }

    private void helper(String s, StringBuilder sb, List<String> res, int leftParen, int rightParen, int idx, HashSet<String> visited) {
        if(idx - sb.length() > s.length() - longest) return;

        if(idx == s.length()) {
            String cand = sb.toString();
            if(leftParen == rightParen && !visited.contains(cand)) {
                if(sb.length() >= longest) {
                    if(sb.length() > longest) {
                        res.clear();
                    }
                    res.add(cand);
                    visited.add(cand);
                    longest = sb.length();
                }
            }
            return;
        }

        char cur = s.charAt(idx);
        if(cur != '(' && cur != ')') {
            sb.append(cur);
            helper(s, sb, res, leftParen, rightParen, idx + 1, visited);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            helper(s, sb, res, leftParen, rightParen, idx + 1, visited);
            if(cur == '(') {
                sb.append(cur);
                helper(s, sb, res, leftParen + 1, rightParen, idx + 1, visited);
                sb.deleteCharAt(sb.length() - 1);
            } else if(leftParen > rightParen) {
                sb.append(cur);
                helper(s, sb, res, leftParen, rightParen + 1, idx + 1, visited);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
