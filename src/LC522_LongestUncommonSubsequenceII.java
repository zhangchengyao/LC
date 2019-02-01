import java.util.Arrays;

public class LC522_LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (x, y) -> x.length()==y.length()?x.compareTo(y):y.length()-x.length());

        for(int i = 0; i < strs.length; i++){
            if(i == strs.length - 1 || !strs[i].equals(strs[i+1])){
                if(isValid(strs, i)) return strs[i].length();
            } else {
                i++;
            }
        }

        return -1;
    }

    private boolean isValid(String[] strs, int i){
        for(int j = i-1; j >= 0; j--){
            if(isSubsequence(strs[i], strs[j])) return false;
        }
        return true;
    }

    private boolean isSubsequence(String a, String b){
        int cur = 0;
        for(int i=0;i<a.length();i++){
            while(cur < b.length() && b.charAt(cur) != a.charAt(i)) cur++;

            if(cur == b.length()) return false;

            cur++;
        }
        return true;
    }
}
