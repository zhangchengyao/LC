public class LC717_1BitAnd2BitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length==1) return true;
        if(bits[bits.length-2]==1) return !check(bits, bits.length-3);
        else return true;
    }
    private boolean check(int[] bits, int end){
        if(end<0) return true;
        if(end==0) return bits[end]==0;
        if(bits[end]==0){
            boolean res = check(bits, end-1);
            if(res) return true;
            if(bits[end-1]==0) return false;
            else return check(bits, end-2);
        }else{
            if(bits[end-1]==0) return false;
            else return check(bits, end-2);
        }
    }
}
