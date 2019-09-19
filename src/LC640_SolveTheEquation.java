public class LC640_SolveTheEquation {
    public String solveEquation(String equation) {
        int sign = 1;
        char operator = '+';
        int coef = 0;
        int constant = 0;
        for(int i = 0; i < equation.length(); i++) {
            if(equation.charAt(i) == 'x') {
                if(operator == '+') coef += sign;
                else coef -= sign;
            } else if(equation.charAt(i) == '=') {
                sign = -1;
                operator = '+';
            } else if(equation.charAt(i) == '+') {
                operator = '+';
            } else if(equation.charAt(i) == '-') {
                operator = '-';
            } else {
                int j = i + 1;
                while(j < equation.length() && Character.isDigit(equation.charAt(j))) j++;
                int val = Integer.parseInt(equation.substring(i, j));
                if(j < equation.length() && equation.charAt(j) == 'x') {
                    if(operator == '+') coef += sign * val;
                    else coef -= sign * val;
                    i = j;
                } else {
                    if(operator == '+') constant += sign * val;
                    else constant -= sign * val;
                    i = j - 1;
                }
            }
        }

        if(coef == 0) {
            if(constant == 0) return "Infinite solutions";
            else return "No solution";
        } else {
            return String.format("x=%d", -constant / coef);
        }
    }
}
