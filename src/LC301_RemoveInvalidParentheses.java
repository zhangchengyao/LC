import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, res, new char[]{'(', ')'}, 0, 0);

        return res;
    }

    private void helper(String s, List<String> res, char[] parens, int cur, int lastDel) {
        int cnt = 0;
        for(int i = cur; i < s.length(); i++) {
            if(s.charAt(i) == parens[0]) cnt++;
            else if(s.charAt(i) == parens[1]) cnt--;

            if(cnt < 0) {
                for(int j = lastDel; j <= i; j++) {
                    if(s.charAt(j) == parens[1] && (j == lastDel || s.charAt(j) != s.charAt(j - 1))) {
                        helper(s.substring(0, j) + s.substring(j + 1), res, parens, i, j);
                    }
                }

                return;
            }
        }

        String rev = new StringBuilder(s).reverse().toString();
        if(parens[0] == '(') helper(rev, res, new char[]{')', '('}, 0, 0);
        else res.add(rev);
    }

//    private int longest = 0;
//    private List<String> res = new ArrayList<>();
//
//    public List<String> removeInvalidParentheses(String s) {
//
//        helper(s, new StringBuilder(), res, 0, 0, 0, new HashSet<>());
//
//        return res;
//    }
//
//    private void helper(String s, StringBuilder sb, List<String> res, int leftParen, int rightParen, int idx, HashSet<String> visited) {
//        if(idx - sb.length() > s.length() - longest) return;
//
//        if(idx == s.length()) {
//            String cand = sb.toString();
//            if(leftParen == rightParen && !visited.contains(cand)) {
//                if(sb.length() >= longest) {
//                    if(sb.length() > longest) {
//                        res.clear();
//                    }
//                    res.add(cand);
//                    visited.add(cand);
//                    longest = sb.length();
//                }
//            }
//            return;
//        }
//
//        char cur = s.charAt(idx);
//        if(cur != '(' && cur != ')') {
//            sb.append(cur);
//            helper(s, sb, res, leftParen, rightParen, idx + 1, visited);
//            sb.deleteCharAt(sb.length() - 1);
//        } else {
//            helper(s, sb, res, leftParen, rightParen, idx + 1, visited);
//            if(cur == '(') {
//                sb.append(cur);
//                helper(s, sb, res, leftParen + 1, rightParen, idx + 1, visited);
//                sb.deleteCharAt(sb.length() - 1);
//            } else if(leftParen > rightParen) {
//                sb.append(cur);
//                helper(s, sb, res, leftParen, rightParen + 1, idx + 1, visited);
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//    }
}
