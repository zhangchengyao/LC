public class LC158_ReadNCharactersGivenRead4IICallMultipleTimes {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int writePos = 0;
    int readPos = 0;
    char[] buff = new char[4];
    public int read(char[] buf, int n) {
        for(int i=0;i<n;i++){
            if(readPos==writePos){
                writePos = read4(buff);
                readPos = 0;
                if(writePos==0) return i;
            }
            buf[i] = buff[readPos];
            readPos++;
        }
        return n;
    }
    int read4(char[] buff){
        return 4;
    }
}
