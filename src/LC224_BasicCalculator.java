import java.util.Stack;

public class LC224_BasicCalculator {
    public int calculate(String s) {
        s = s.trim();
        char[] str = s.toCharArray();
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int curVal = 0;
        char operator = '+';
        for(int i=0;i<str.length;i++){
            if(Character.isDigit(str[i])){
                int j = i+1;
                while(j<str.length && Character.isDigit(str[j])) j++;
                curVal = eval(curVal, Integer.parseInt(s.substring(i, j)), operator);
                i = j-1;
            }
            else if(str[i]=='+'||str[i]=='-'){
                operator = str[i];
            }
            else if(str[i]=='('){
                values.push(curVal);
                operators.push(operator);
                curVal = 0;
                operator = '+';
            }
            else if(str[i]==')'){
                curVal = eval(values.pop(), curVal, operators.pop());
            }
        }
        return curVal;
    }
    private int eval(int a, int b, char operator){
        if(operator=='+') return a+b;
        else return a-b;
    }
    // recusion slow
//    class Term{
//        char operator;
//        int val;
//        Term(char o, int v){
//            operator = o;
//            val = v;
//        }
//    }
//
//    public int calculate(String s) {
//        s = s.replace(" ", "");
//        return cal(s);
//    }
//
//    private int cal(String s){
//        int i = 0;
//        int j = i;
//        Term res = null;
//        Term cur = null;
//        if(s.charAt(i) == '('){
//            j = getCloseParen(s, i);
//            int val = cal(s.substring(i + 1, j));
//            res = new Term('+', val);
//        } else {
//            j++;
//            while(j < s.length() && Character.isDigit(s.charAt(j))) j++;
//            res = new Term('+', Integer.parseInt(s.substring(i, j)));
//        }
//
//        i = j;
//        while(i < s.length()){
//            if(s.charAt(i) == ')'){
//                i++;
//                continue;
//            }
//            char ope = s.charAt(i);
//            j = i + 1;
//            if(s.charAt(j) == '('){
//                j = getCloseParen(s, j);
//                cur = new Term(ope, cal(s.substring(i + 2, j)));
//            } else {
//                while(j < s.length() && Character.isDigit(s.charAt(j))) j++;
//                cur = new Term(ope, Integer.parseInt(s.substring(i + 1, j)));
//            }
//
//            res = collapse(res, cur);
//
//            i = j;
//        }
//
//        return res.val;
//    }
//
//    private int getCloseParen(String s, int i){
//        int cnt = 1;
//        i++;
//        while(i < s.length() && cnt != 0){
//            if(s.charAt(i) == '(') cnt++;
//            else if(s.charAt(i) == ')') cnt--;
//
//            i++;
//        }
//        return i;
//    }
//
//    private Term collapse(Term a, Term b){
//        char ope = b.operator;
//        int val = 0;
//        if(ope == '+'){
//            val = a.val + b.val;
//        } else if(ope == '-'){
//            val = a.val - b.val;
//        }
//
//        return new Term('+', val);
//    }
}
