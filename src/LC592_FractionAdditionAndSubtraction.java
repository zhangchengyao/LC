public class LC592_FractionAdditionAndSubtraction {
    class Term{
        int numerator;
        int denominator;

        Term(int n, int d){
            numerator = n;
            denominator = d;
        }
    }
    public String fractionAddition(String expression) {
        Term t1 = null;
        Term t2;
        char ope = '+';
        for(int i = 0; i < expression.length(); i++){
            int j = i + 1;
            while(expression.charAt(j) != '/') j++;
            int numer = Integer.parseInt(expression.substring(i, j));

            int k = j + 2;
            while(k < expression.length() && Character.isDigit(expression.charAt(k))) k++;
            int deno = Integer.parseInt(expression.substring(j + 1, k));

            if(t1 == null){
                t1 = new Term(numer, deno);
            } else {
                t2 = new Term(numer, deno);
                t1 = collapse(t1, t2, ope);
            }
            if(k < expression.length()){
                ope = expression.charAt(k);
            }

            i = k;
        }

        return t1.numerator + "/" + t1.denominator;
    }

    private Term collapse(Term t1, Term t2, char ope){
        int numer;
        if(ope == '+'){
            numer = t1.numerator * t2.denominator + t2.numerator * t1.denominator;
        } else {
            numer = t1.numerator * t2.denominator - t2.numerator * t1.denominator;
        }

        int deno = t1.denominator * t2.denominator;
        int gcd = gcd(Math.abs(numer), Math.abs(deno));
        t1.numerator = numer / gcd;
        t1.denominator = deno / gcd;

        return t1;
    }

    private int gcd(int a, int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }
}
