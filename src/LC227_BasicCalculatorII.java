public class LC227_BasicCalculatorII {
    class Term{
        char operator;
        int val;
        Term(char o, int v){
            operator = o;
            val = v;
        }
    }
    public int calculate(String s) {
        s = s.replace(" ", "");

        int i = 0;
        int j = i + 1;
        while(j < s.length() && Character.isDigit(s.charAt(j))) j++;
        Term cur = new Term('+', Integer.parseInt(s.substring(i, j)));
        i = j;
        Term res = null;
        Term next;

        while(i < s.length()){
            char ope = s.charAt(i);
            j = i + 1;
            while(j < s.length() && Character.isDigit(s.charAt(j))) j++;

            next = new Term(ope, Integer.parseInt(s.substring(i+1, j)));
            if(next.operator != '*' && next.operator != '/'){
                res = collapse(res, cur);
                cur = next;
            } else {
                cur = collapse(cur, next);
            }

            i = j;
        }

        res = collapse(res, cur);
        return res.val;
    }

    private Term collapse(Term a, Term b){
        if(a == null){
            return b;
        }

        char ope = b.operator;
        switch(ope){
            case '+':
                a.val += b.val;
                break;
            case '-':
                a.val -= b.val;
                break;
            case '*':
                a.val *= b.val;
                break;
            case '/':
                a.val /= b.val;
                break;
            default:
                break;
        }

        return a;
    }
}
