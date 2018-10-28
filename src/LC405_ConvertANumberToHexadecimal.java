public class LC405_ConvertANumberToHexadecimal {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        String hex = "0123456789abcdef";
        while(num!=0){
            int t = num & 0xf;
            sb.insert(0, hex.charAt(t));
            num >>>= 4;
        }
        return sb.toString();
    }
//    public String toHex(int num) {
//        String binary = Integer.toBinaryString(num);
//        StringBuilder sb = new StringBuilder();
//        for(int i=binary.length()-1;i>=0;i-=4){
//            String tmp = binary.substring(Math.max(0, i-3),i+1);
//            int sum = 0;
//            for(int j=0;j<tmp.length();j++){
//                if(tmp.charAt(tmp.length()-j-1)!='0') sum += Math.pow(2, j);
//            }
//            if(sum<10) sb.insert(0, sum);
//            else sb.insert(0, (char)((sum-10)+'a'));
//        }
//        return sb.toString();
//    }
}
