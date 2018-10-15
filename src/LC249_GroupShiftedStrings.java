import java.util.*;

public class LC249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if(strings==null || strings.length==0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strings){
            StringBuilder sb = new StringBuilder();
            char c = str.charAt(0);
            for(int i=1;i<str.length();i++){
                sb.append((str.charAt(i)-c+26)%26).append(" ");
            }
            String s = sb.toString();
            if(map.containsKey(s)) map.get(s).add(str);
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        for(String s: map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
//    public List<List<String>> groupStrings(String[] strings){
//        HashMap<String, TreeSet<String>> map  = new HashMap<>();
//        for(int i=0;i<strings.length;i++){
//            String cur = strings[i];
//            char first = cur.charAt(0);
//            StringBuilder tmp = new StringBuilder();
//            for(int j=1;j<cur.length();j++){
//                tmp.append(((cur.charAt(j)-first)+26)%26).append(" ");
//            }
//            if(map.containsKey(tmp.toString())) map.get(tmp.toString()).add(cur);
//            else{
//                TreeSet<String> ts = new TreeSet<>();
//                ts.add(cur);
//                map.put(tmp.toString(), ts);
//            }
//        }
//        List<List<String>> res = new ArrayList<>();
//        for(TreeSet<String> ts: map.values()){
//            List<String> item = new ArrayList<>(ts);
//            res.add(item);
//        }
//        return res;
//    }
}
