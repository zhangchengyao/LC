import java.util.*;

public class LC721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        for(List<String> list: accounts) {
            String name = list.get(0);
            for(int j = 1; j < list.size(); j++) {
                parent.putIfAbsent(list.get(j), list.get(j));
                emailToName.put(list.get(j), name);
                if(j > 1) union(list.get(1), list.get(j), parent);
            }
        }

        Map<String, List<String>> mergedAccounts = new HashMap<>();
        for(String email: emailToName.keySet()) {
            String root = find(email, parent);
            if(!mergedAccounts.containsKey(root)) {
                mergedAccounts.put(root, new ArrayList<>());
                mergedAccounts.get(root).add(emailToName.get(email));
            }
            mergedAccounts.get(root).add(email);
        }

        for(List<String> list: mergedAccounts.values()) Collections.sort(list);

        return new ArrayList<>(mergedAccounts.values());
    }

    private String find(String a, Map<String, String> parent){
        while(!parent.get(a).equals(a)){
            parent.put(a, parent.get(parent.get(a)));
            a = parent.get(a);
        }
        return a;
    }
    private void union(String a, String b, Map<String, String> parent){
        String root1 = find(a, parent);
        String root2 = find(b, parent);
        if(root1.equals(root2)) return ;
        parent.put(root1, root2);
    }
}
