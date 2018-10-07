import java.util.ArrayList;
import java.util.TreeSet;

public class LC269_AlienDictionary {
    public String alienOrder(String[] words) {
        ArrayList<Character> dic = new ArrayList<>();
        TreeSet<Character> set = new TreeSet<>();
        boolean finish = false;
        int p = 0;
        while(!finish){
            finish = true;
            for(int i=0;i<words.length;i++){
                if(p>=words[i].length()) continue;
                finish = false;
                if(i==0){
                    if(!dic.contains(words[i].charAt(p))) set.add(words[i].charAt(p));
                    continue;
                }
                if(words[i-1].substring(0,p).equals(words[i].substring(0,p))){
                    char c1 = words[i].charAt(p);
                    char c2 = words[i-1].charAt(p);
                    if(c1!=c2){
                        if(set.contains(c2)){
                            dic.add(c2);
                            set.remove(c2);
                        }
                        int index1 = dic.indexOf((Character)c1);
                        int index2 = dic.indexOf((Character)c2);
                        if(index1<index2){
                            if(index1==-1){
                                dic.add(index2+1, c1);
                                if(set.contains(c1)) set.remove(c1);
                            }
                            else return "";
                        }
                    }
                }else{
                    if(!dic.contains(words[i].charAt(p))) set.add(words[i].charAt(p));
                }
            }
            p++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c: dic) sb.append(c);
        int i = 0;
        for(char c: set){
            while(i<sb.length() && c>sb.charAt(i)) i++;
            sb.insert(i, c);
        }
        return sb.toString();
    }
}
