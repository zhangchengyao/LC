public class LC482_LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S.toUpperCase());
        int p = sb.length()-1;
        int cnt = 0;
        while(p>=0){
            if(sb.charAt(p)!='-') cnt++;
            else sb.deleteCharAt(p);
            if(cnt==K){
                if(p!=0) sb.insert(p, '-');
                cnt = 0;
            }
            p--;
        }
        int idx = 0;
        while(idx<sb.length()&&sb.charAt(idx)=='-') idx++;
        return sb.toString().substring(idx);
    }
}
