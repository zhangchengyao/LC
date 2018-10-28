import java.util.HashMap;
import java.util.HashSet;

public class LC166_FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(numerator*1.0/denominator<0) sb.append('-');
        long numeratorL = Math.abs((long)numerator);
        long denominatorL = Math.abs((long)denominator);
        long intPart = numeratorL/denominatorL;
        sb.append(intPart);
        numeratorL %= denominatorL;
        if(numeratorL==0) return sb.toString();
        sb.append('.');
        int posOfDot = sb.indexOf(".");
        HashMap<Long, Integer> map = new HashMap<>();
        int idx = 0;
        while(numeratorL!=0){
            if(map.containsKey(numeratorL)){
                sb.insert(posOfDot+map.get(numeratorL)+1, '(');
                sb.append(')');
                return sb.toString();
            }
            map.put(numeratorL, idx);
            long num = numeratorL*10/denominatorL;
            numeratorL = (numeratorL*10)%denominatorL;
            sb.append(num);
            idx++;
        }
        return sb.toString();
    }
}
