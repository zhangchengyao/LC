public class LC443_StringCompression {
    public int compress(char[] chars) {
        int compressed = 0;
        for(int i=0;i<chars.length;i++){
            int j = i+1;
            while(j<chars.length && chars[i]==chars[j]) j++;
            int dist = j-i;
            chars[compressed] = chars[i];
            compressed++;
            if(dist>1){
                String str = String.valueOf(dist);
                for(int k=0;k<str.length();k++){
                    chars[compressed+k] = str.charAt(k);
                }
                compressed += str.length();
            }
            i = j-1;
        }

        return compressed;
    }
}
