public class LC717_1BitAnd2BitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length) {
            if(bits[i] == 1) i += 2;
            else if(i == bits.length - 1) return true;
            else i++;
        }

        return false;
    }
}
