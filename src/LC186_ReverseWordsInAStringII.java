public class LC186_ReverseWordsInAStringII {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);

        int l = 0;
        int r = l + 1;
        while(l < str.length){
            while(r < str.length && str[r] != ' ') r++;
            reverse(str, l, r - 1);
            l = r + 1;
            r = l + 1;
        }
    }

    private void reverse(char[] str, int start, int end){
        int l = start;
        int r = end;
        while(l < r){
            char tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
    }
}
