public class LC860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0;
        int cnt10 = 0;
        for(int bill: bills) {
            if(bill == 5) {
                cnt5++;
            } else if(bill == 10) {
                cnt10++;
                cnt5--;
            } else {
                if(cnt10 == 0) {
                    cnt5 -= 3;
                } else {
                    cnt10--;
                    cnt5--;
                }
            }
            if(cnt5 < 0) return false;
        }

        return true;
    }
}
