public class LC806_NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int lines = 1;
        int size = 0;
        for(char c: S.toCharArray()) {
            int width = widths[c - 'a'];
            if(size + width > 100) {
                lines++;
                size = width;
            } else {
                size += width;
            }
        }

        return new int[]{lines, size};
    }
}
