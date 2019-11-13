import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC609_FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths) {
            String[] info = path.split(" ");
            String dir = info[0];
            for(int i = 1; i < info.length; i++) {
                String f = info[i];
                int l = f.indexOf("(");
                int r = f.indexOf(")");
                String content = f.substring(l + 1, r);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(String.format("%s/%s", dir, f.substring(0, l)));
            }
        }

        List<List<String>> res = new ArrayList<>();

        for(List<String> group: map.values()) {
            if(group.size() > 1) res.add(group);
        }

        return res;
    }
}
