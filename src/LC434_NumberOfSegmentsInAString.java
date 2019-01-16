public class LC434_NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') continue;
            int j = i+1;
            while(j<s.length() && s.charAt(j)!=' ') j++;
            i = j;
            cnt++;
        }
        return cnt;
    }
}
