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
//    public int calculate(String s) {
//        s = s.trim();
//        int idx = s.indexOf('(');
//        if(idx<0){
//            int res = 0;
//            int l = 0;
//            while(l<s.length()){
//                int r = l+1;
//                while(r<s.length() && s.charAt(r)!='+' && s.charAt(r)!='-') r++;
//                if(l==0 || s.charAt(l-1)=='+') res += Integer.parseInt(s.substring(l, r).trim());
//                else res -= Integer.parseInt(s.substring(l, r).trim());
//                l = r+1;
//            }
//            return res;
//        }
//        else{
//            int cnt = 0;
//            int idxClose = 0;
//            for(int i=idx;i<s.length();i++){
//                if(s.charAt(i)=='(') cnt++;
//                else if(s.charAt(i)==')') cnt--;
//                if(cnt==0){
//                    idxClose = i;
//                    break;
//                }
//            }
//            StringBuilder sb = new StringBuilder(s);
//            sb.delete(idx, idxClose+1);
//            sb.insert(idx, calculate(s.substring(idx+1, idxClose)));
//            return calculate(sb.toString());
//        }
//    }
}
