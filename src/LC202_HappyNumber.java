import java.util.HashSet;

public class LC202_HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(true){
            int sum = 0;
            while(n>0){
                sum += Math.pow((n%10), 2);
                n /= 10;
            }
            n = sum;
            if(n==1) return true;
            if(set.contains(n)) return false;
            else set.add(n);
        }
    }
}
