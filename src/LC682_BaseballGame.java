import java.util.Stack;

public class LC682_BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> validScores = new Stack<>();
        int scores = 0;
        for(String op: ops) {
            switch (op) {
                case "+": {
                    int a = validScores.pop();
                    int b = validScores.peek();
                    validScores.add(a);
                    validScores.push(a + b);
                    scores += a + b;
                    break;
                }
                case "D": {
                    int a = validScores.peek();
                    validScores.push(a * 2);
                    scores += a * 2;
                    break;
                }
                case "C": {
                    int a = validScores.pop();
                    scores -= a;
                    break;
                }
                default:
                    int val = Integer.parseInt(op);
                    validScores.push(val);
                    scores += val;
                    break;
            }
        }

        return scores;
    }
}
