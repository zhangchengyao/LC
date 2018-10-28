import java.util.*;

public class LC721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, TreeSet<String>> rootToEmails = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        for(List<String> list: accounts){
            String name = list.get(0);
            for(int j=1;j<list.size();j++){
                parent.put(list.get(j), list.get(j));
                emailToName.put(list.get(j), name);
            }
        }
        for(List<String> list: accounts){
            String email = list.get(1);
            for(int j=2;j<list.size();j++){
                union(email, list.get(j), parent);
            }
        }
        for(List<String> list: accounts){
            for(int j=1;j<list.size();j++){
                String root = find(list.get(j), parent);
                TreeSet<String> ts = rootToEmails.getOrDefault(root, new TreeSet<>());
                ts.add(list.get(j));
                rootToEmails.put(root, ts);
            }
        }
        for(Map.Entry<String, TreeSet<String>> entry: rootToEmails.entrySet()){
            List<String> tmp = new ArrayList<>();
            String name = emailToName.get(entry.getKey());
            tmp.add(name);
            tmp.addAll(entry.getValue());
            res.add(tmp);
        }
        return res;
    }

    private String find(String a, HashMap<String, String> parent){
        while(!parent.get(a).equals(a)){
            parent.put(a, parent.get(parent.get(a)));
            a = parent.get(a);
        }
        return a;
    }
    private void union(String a, String b, HashMap<String, String> parent){
        String root1 = find(a, parent);
        String root2 = find(b, parent);
        if(root1.equals(root2)) return ;
        parent.put(root1, root2);
    }
}
