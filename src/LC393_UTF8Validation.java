public class LC393_UTF8Validation {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while(i<data.length){
            int leadingOne = countLeadingOne(data[i]);
            if(leadingOne>4 || leadingOne==1) return false;
            if(leadingOne==0){
                i++;
            } else {
                if(i+leadingOne-1>=data.length) return false;
                for(int k=1;k<leadingOne;k++){
                    if(countLeadingOne(data[i+k])!=1) return false;
                }
                i += leadingOne;
            }
        }

        return true;
    }

    private int countLeadingOne(int x){
        int cnt = 0;
        for(int offset=7;offset>=0;offset--){
            if( ((x>>offset)&1) == 1 ) cnt++;
            else break;
        }
        return cnt;
    }
}
