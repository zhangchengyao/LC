import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args){
        LC249_GroupShiftedStrings lc = new LC249_GroupShiftedStrings();
        List<List<String>> res = lc.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
        for(List<String> line: res){
            for(String s: line){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
