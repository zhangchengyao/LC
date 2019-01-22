public class LC504_Base7 {
    public String convertToBase7(int num) {
        if(num<0) return "-"+convertToBase7(-num);
        if(num==0) return "0";

        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.insert(0, num%7);
            num /= 7;
        }
        return sb.toString();
    }
}
