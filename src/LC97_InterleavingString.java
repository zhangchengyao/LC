import java.util.HashMap;

public class LC97_InterleavingString {
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        return interleave(s3, s1, s2, true) || interleave(s3, s1, s2, false);
    }

    private boolean interleave(String s3, String s1, String s2, boolean fromS1){
        if(s3.equals("") && s1.equals("") & s2.equals("")) return true;

        String state = s3 + s1 + s2 + fromS1;
        if(memo.containsKey(state)) return memo.get(state);

        boolean res = false;

        for(int len=1;len<=s3.length();len++){
            if(fromS1){
                if(len>s1.length() || !s3.substring(0, len).equals(s1.substring(0, len))) break;
                res = interleave(s3.substring(len), s1.substring(len), s2, false);
                if(res) return res;
            } else {
                if(len>s2.length() || !s3.substring(0, len).equals(s2.substring(0, len))) break;
                res = interleave(s3.substring(len), s1, s2.substring(len), true);
                if(res) return res;
            }
        }

        memo.put(state, false);
        return false;
    }
}
