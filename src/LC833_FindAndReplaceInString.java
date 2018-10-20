import java.util.Arrays;
import java.util.Comparator;

public class LC833_FindAndReplaceInString {
    class Operation{
        int index;
        String src;
        String target;
        Operation(int index, String src, String target){
            this.index = index;
            this.src = src;
            this.target = target;
        }
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(S);
        Operation[] opes = new Operation[indexes.length];
        for(int i=0;i<indexes.length;i++){
            opes[i] = new Operation(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(opes, new Comparator<Operation>(){
            public int compare(Operation o1, Operation o2){
                return o1.index-o2.index;
            }
        });
        int lenInc = 0;
        for(Operation o: opes){
            int idx = o.index+lenInc;
            if(sb.substring(idx, idx+o.src.length()).equals(o.src)){
                lenInc += o.target.length()-o.src.length();
                for(int i=0;i<o.src.length();i++) sb.deleteCharAt(idx);
                sb.insert(idx, o.target);
            }
        }
        return sb.toString();
    }
}
