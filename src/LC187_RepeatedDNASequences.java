import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC187_RepeatedDNASequences {
    // todo bit manipulation
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()<=10) return res;

        HashMap<String, Integer> seqs = new HashMap<>();
        for(int i=0;i+10<=s.length();i++){
            String seq = s.substring(i, i+10);
            if(seqs.get(seq)!=null && seqs.get(seq)==1){
                res.add(seq);
                seqs.put(seq, 2);
            }
            else if(seqs.get(seq)==null){
                seqs.put(seq, 1);
            }
        }

        return res;
    }
}
