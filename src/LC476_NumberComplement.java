public class LC476_NumberComplement {
    public int findComplement(int num) {
        int pos = -1;
        for(int i=31;i>=0;i--){
            if((num&(1<<i))!=0){
                pos = i;
                break;
            }
        }
        if(pos==-1) return 1;
        int mask = 0;
        for(int i=0;i<=pos;i++) mask |= 1<<i;
        return (num^mask);
    }
}
