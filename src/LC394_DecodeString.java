public class LC394_DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;

        int i = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder number = new StringBuilder();
        while(i < s.length()){
            if(s.charAt(i) == '['){
                int end = indexOfCloseBracket(s, i);
                String sub = decodeString(s.substring(i + 1, end));

                int repeat = Integer.parseInt(number.toString());
                for(int k = 0; k < repeat; k++){
                    sb.append(sub);
                }

                i = end + 1;
                number = new StringBuilder();
            } else if(Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
                i++;
            } else {
                number.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    private int indexOfCloseBracket(String s, int i){
        int cnt = 0;
        while(i < s.length()){
            if(s.charAt(i) == '[') cnt++;
            else if(s.charAt(i) == ']') cnt--;

            if(cnt == 0) break;
            i ++;
        }
        return i;
    }
}
