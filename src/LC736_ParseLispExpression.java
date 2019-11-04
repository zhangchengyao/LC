import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC736_ParseLispExpression {
    public int evaluate(String expression) {
        Map<String, Integer> map = new HashMap<>();
        return evaluate(expression, map);
    }

    private int evaluate(String expression, Map<String, Integer> map) {
        if(expression.charAt(0) == '(') {
            if(expression.substring(1, 4).equals("let")) {
                List<String> exprs = parse(expression.substring(5, expression.length() - 1));
                for(int i = 0; i < exprs.size() - 1; i += 2){
                    map.put(exprs.get(i), evaluate(exprs.get(i + 1), new HashMap<>(map)));
                }
                return evaluate(exprs.get(exprs.size() - 1), new HashMap<>(map));
            } else if(expression.substring(1, 4).equals("add")) {
                List<String> exprs = parse(expression.substring(5, expression.length() - 1));
                return evaluate(exprs.get(0), new HashMap<>(map)) + evaluate(exprs.get(1), new HashMap<>(map));
            } else {
                List<String> exprs = parse(expression.substring(6, expression.length() - 1));
                return evaluate(exprs.get(0), new HashMap<>(map)) * evaluate(exprs.get(1), new HashMap<>(map));
            }
        } else {
            if(Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            } else {
                return map.get(expression);
            }
        }
    }
    private List<String> parse(String expression) {
        List<String> res = new ArrayList<>();
        int cur = 0;
        while(cur < expression.length()) {
            int p = cur + 1;
            if(expression.charAt(cur) == '(') {
                int cnt = 1;
                while(p < expression.length()) {
                    if(expression.charAt(p) == '(') cnt++;
                    else if(expression.charAt(p) == ')') cnt--;
                    p++;
                    if(cnt == 0) break;
                }
            } else {
                while(p < expression.length() && expression.charAt(p) != ' ') p++;
            }
            res.add(expression.substring(cur, p));
            cur = p + 1;
        }
        return res;
    }
}
