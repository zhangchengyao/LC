import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC893_GroupsOfSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();

        for(String str: A) {
            int[] count = new int[52];
            for(int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a' + 26 * (i & 1)]++;
            }

            seen.add(Arrays.toString(count));
        }

        return seen.size();
    }

//    public int numSpecialEquivGroups(String[] A) {
//        Set<String> canonicals = new HashSet<>();
//        for(String str: A) {
//            char[] even = new char[(str.length() + 1) / 2];
//            char[] odd = new char[str.length() / 2];
//            for(int i = 0; i < str.length(); i++) {
//                if(i % 2 == 0) even[i / 2] = str.charAt(i);
//                else odd[i / 2] = str.charAt(i);
//            }
//            Arrays.sort(even);
//            Arrays.sort(odd);
//
//            canonicals.add(new String(even) + " " + new String(odd));
//        }
//
//        return canonicals.size();
//    }
}
