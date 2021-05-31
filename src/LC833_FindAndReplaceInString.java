import java.util.Arrays;

public class LC833_FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int[] replaces = new int[S.length()];
        Arrays.fill(replaces, -1);

        for(int i = 0; i < indexes.length; i++) {
            int idx = indexes[i];
            if(S.substring(idx, idx + sources[i].length()).equals(sources[i])) replaces[idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < replaces.length; i++) {
            if(replaces[i] != -1) {
                sb.append(targets[replaces[i]]);
                i += sources[replaces[i]].length() - 1;
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }
}
