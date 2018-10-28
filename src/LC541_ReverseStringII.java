public class LC541_ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i+=2*k){
            for(int j=Math.min(s.length()-1, i+k-1);j>=i;j--){
                sb.append(s.charAt(j));
            }
            for(int j=i+k;j<Math.min(s.length(), i+2*k);j++){
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}
