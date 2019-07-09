public class LC158_ReadNCharactersGivenRead4IICallMultipleTimes {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int read = 0;
    private int count = 0;
    private char[] buff = new char[4];

    public int read(char[] buf, int n) {
        int total = 0;
        for(int i = 0; i < n; i++) {
            if(read == count) {
                count = read4(buff);
                read = 0;
            }
            if(count == 0) break;
            buf[i] = buff[read++];
            total++;
        }

        return total;
    }
    int read4(char[] buff){
        return 4;
    }
}
