import java.util.ArrayList;
import java.util.HashMap;

public class LC527_WordAbbreviation {
    public String[] wordsAbbreviation(String[] dict) {
        ArrayList<String> arr = new ArrayList<>();
        for(String s: dict) arr.add(s);
        String[] res = new String[dict.length];
        HashMap<String, String> map = new HashMap<>();
        boolean finish = false;
        int size = 1;
        while(!finish){
            finish = true;
            // map = new HashMap<>();
            for(int i=0;i<dict.length;i++){
                if(res[i]!=null) continue;
                String abb = getAbbr(dict[i], size);
                if(map.containsKey(abb)){
                    int index = arr.indexOf(map.get(abb));
                    res[index] = null;
                    finish = false;
                }else{
                    map.put(abb, dict[i]);
                    res[i] = abb;
                }
            }
            size++;
        }
        return res;
    }
    private String getAbbr(String str, int size){
        if(size>=str.length()-2) return str;
        return str.substring(0, size)+(str.length()-size-1)+str.charAt(str.length()-1);
    }
}
