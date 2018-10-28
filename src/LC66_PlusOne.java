public class LC66_PlusOne {
    public int[] plusOne(int[] digits) {
        int cur = digits.length - 1;
        while(cur>=0 && (++digits[cur])==10){
            digits[cur] = 0;
            cur--;
        }
        if(cur<0){
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            return newDigits;
        }else{
            return digits;
        }
    }
}
