public class LC507_PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num<=1) return false;

        int sum = 0;
        double upper = Math.sqrt(num);
        for(int i=1;i<=upper;i++){
            if(num%i==0){
                sum += i;
                if(i!=1 && i!=upper){
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }
}
