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
        Arrays.sort(opes, (a,b) -> b.index-a.index);
        for(Operation o: opes){
            if(sb.substring(o.index, o.index+o.src.length()).equals(o.src)){
                for(int i=0;i<o.src.length();i++) sb.deleteCharAt(o.index);
                sb.insert(o.index, o.target);
            }
        }
        return sb.toString();
    }
}
