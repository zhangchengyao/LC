public class LC394_DecodeString {
    public String decodeString(String s) {
        int cnt = 0;
        boolean hasBracket = false;
        int l = 0;
        int r = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                if(!hasBracket){
                    hasBracket = true;
                    l = i;
                }
                cnt++;
            }else if(s.charAt(i)==']'){
                cnt--;
                if(cnt==0){
                    r = i;
                    int k = l-1;
                    while(k>=0 && s.charAt(k)>='0' && s.charAt(k)<='9') k--;
                    int repeat = Integer.parseInt(s.substring(k+1, l));
                    String str = decodeString(s.substring(l+1, r));
                    for(int j=0;j<repeat;j++){
                        res.append(str);
                    }
                    hasBracket = false;
                }
            }else if(!(s.charAt(i)>='0' && s.charAt(i)<='9') && !hasBracket) res.append(s.charAt(i));
        }
        return res.toString();
    }
}
