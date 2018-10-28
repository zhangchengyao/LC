import java.util.ArrayList;
import java.util.List;

public class LC68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        while(idx<words.length){
            StringBuilder sb = new StringBuilder();
            int len = 0;
            int cnt = 0;
            while(idx<words.length && len+words[idx].length()<=maxWidth){
                len += words[idx++].length()+1;
                cnt ++;
            }
            if(idx==words.length){
                for(int i=0;i<cnt-1;i++) sb.append(words[idx-cnt+i]).append(' ');
                sb.append(words[idx-1]);
                int curLen = sb.length();
                for(int i=0;i<maxWidth-curLen;i++) sb.append(' ');
            }
            else{
                if(cnt==1){
                    sb.append(words[idx-1]);
                    int curLen = sb.length();
                    for(int i=0;i<maxWidth-curLen;i++) sb.append(' ');
                }
                else{
                    int gap = cnt-1;
                    int spaces = maxWidth-(len-cnt);
                    int[] numSpace = new int[gap];
                    int i = gap-1;
                    while(spaces%gap!=0){
                        numSpace[i] = spaces/gap;
                        gap--;
                        spaces -= numSpace[i];
                        i--;
                    }
                    while(i>=0) numSpace[i--] = spaces/gap;
                    for(i=0;i<numSpace.length;i++){
                        sb.append(words[idx-cnt+i]);
                        for(int j=0;j<numSpace[i];j++) sb.append(' ');
                    }
                    sb.append(words[idx-1]);
                }

            }
            res.add(sb.toString());
        }
        return res;
    }
}
