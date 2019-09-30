import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC811_SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Long> map = new HashMap<>();
        for(String pair: cpdomains) {
            long cnt = Long.parseLong(pair.split(" ")[0]);
            String domain = pair.split(" ")[1];
            int idx = 0;
            while(idx >= 0) {
                domain = domain.substring(idx);
                map.put(domain, map.getOrDefault(domain, 0L) + cnt);

                idx = domain.indexOf(".");
                if(idx < 0) idx--;
                idx++;
            }
        }

        List<String> res = new ArrayList<>();
        for(String domain: map.keySet()) {
            res.add(map.get(domain) + " " + domain);
        }

        return res;
    }
}
