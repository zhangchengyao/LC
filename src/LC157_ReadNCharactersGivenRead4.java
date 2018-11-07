public class LC157_ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        int total = 0; // Total characters that have been read into the buffer
        char[] tmp = new char[4];
        boolean eof = false;

        while (!eof && total < n) {
            int count = read4(tmp);
            eof = (count < 4);

            // in case that n is less than the length of file
            count = Math.min(count, n - total);

            for (int i = 0; i < count; i++) {
                buf[total++] = tmp[i];
            }
        }

        return total;
    }
    int read4(char[] buf){
        return 4;
    }
}
