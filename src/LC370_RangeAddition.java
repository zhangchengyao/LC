public class LC370_RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update: updates){
            for(int i=update[0];i<=update[1];i++){
                res[i] += update[2];
            }
        }
        return res;
    }
    // genius solution
//    public int[] getModifiedArray(int length, int[][] updates) {
//        int[] res = new int[length];
//        for(int[] update: updates){
//            res[update[0]] += update[2];
//            if(update[1]<length-1) res[update[1]+1] -= update[2];
//        }
//        for(int i=1;i<length;i++){
//            res[i] += res[i-1];
//        }
//        return res;
//    }
}
