public class LC418_SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if(rows == 0 || cols == 0) return 0;

        int totalLen = 0;
        for(String s: sentence) totalLen += s.length() + 1;

        int colRemain;
        int idx = 0;
        int res = 0;
        for(int r = 0; r < rows; r++){
            colRemain = cols;
            while(colRemain > 0){
                if(colRemain >= sentence[idx].length()){
                    colRemain -= sentence[idx].length();
                    if(colRemain > 0) colRemain--;
                    idx++;
                }
                else break;
                if(idx == sentence.length){
                    res += 1 + colRemain / totalLen;
                    colRemain %= totalLen;
                    idx = 0;
                }
            }
        }
        return res;
    }
}
