import java.util.ArrayList;
import java.util.List;

public class LC271_EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append(':').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        while(!s.equals("")){
            int idx = s.indexOf(':');
            int len = Integer.parseInt(s.substring(0, idx));
            res.add(s.substring(idx+1, idx+len+1));
            s = s.substring(idx+len+1);
        }
        return res;
    }
}
