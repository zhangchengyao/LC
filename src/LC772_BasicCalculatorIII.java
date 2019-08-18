import java.util.Stack;

public class LC772_BasicCalculatorIII {
    public int calculate(String s) {
        if(!s.contains("(")) {
            String rpn = convert(s);
            return (int)evaluate(rpn);
        } else {
            StringBuilder sb = new StringBuilder();
            int fromIdx = 0;
            while(true) {
                int i = s.indexOf("(", fromIdx);
                if(i < 0) break;
                sb.append(s, fromIdx, i);
                int j = indexOfCloseParen(s, i);
                sb.append(calculate(s.substring(i + 1, j)));
                fromIdx = j + 1;
            }
            if(fromIdx < s.length()) sb.append(s.substring(fromIdx));
            return calculate(sb.toString());
        }
    }

    private int indexOfCloseParen(String s, int idx) {
        int cnt = 1;
        int k = idx + 1;
        while(k < s.length()) {
            if(s.charAt(k) == '(') cnt++;
            else if(s.charAt(k) == ')') cnt--;

            if(cnt == 0) break;
            k++;
        }
        return k;
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        boolean wasOperator = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c) || wasOperator) {
                wasOperator = false;
                int j = i + 1;
                while(j < s.length() && Character.isDigit(s.charAt(j))) j++;
                sb.append(s, i, j).append(' ');
                i = j - 1;
            } else {
                wasOperator = true;
                while(!operators.isEmpty() && priority(operators.peek()) >= priority(c)) {
                    sb.append(operators.pop()).append(' ');
                }
                operators.push(c);
            }
        }

        while(!operators.isEmpty()) {
            sb.append(operators.pop()).append(' ');
        }

        return sb.toString().trim();
    }

    private long evaluate(String s) {
        String[] terms = s.split(" ");
        Stack<Long> numbers = new Stack<>();
        for(String term: terms) {
            if(term.length() > 1 || Character.isDigit(term.charAt(0))) {
                numbers.push(Long.parseLong(term));
            } else {
                long b = numbers.pop();
                long a = numbers.pop();
                switch(term) {
                    case "+":
                        numbers.push(a + b);
                        break;
                    case "-":
                        numbers.push(a - b);
                        break;
                    case "*":
                        numbers.push(a * b);
                        break;
                    default:
                        numbers.push(a / b);
                        break;
                }
            }
        }

        return numbers.pop();
    }

    private int priority(char c) {
        if(c == '*' || c == '/') return 1;
        else return 0;
    }
}
