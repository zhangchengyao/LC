import java.util.ArrayList;
import java.util.List;

public class LC635_DesignLogStorageSystem {
    class Log {
        int id;
        String timestamp;
        Log(int _id, String _timestamp) {
            id = _id;
            timestamp = _timestamp;
        }
    }

    private List<Log> logs;
    private String[] granularities;
    private int[] indices;

    public LC635_DesignLogStorageSystem() {
        logs = new ArrayList<>();
        granularities = new String[]{"Year", "Month", "Day", "Hour", "Minute", "Second"};
        indices = new int[]{4, 7, 10, 13, 16, 19};
    }

    public void put(int id, String timestamp) {
        logs.add(new Log(id, timestamp));
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int idx = 0;
        for(int i = 0; i < indices.length; i++) {
            if(granularities[i].equals(gra)) {
                idx = indices[i];
                break;
            }
        }

        List<Integer> res = new ArrayList<>();
        String lower = s.substring(0, idx);
        String higher = e.substring(0, idx);
        for(Log log: logs) {
            String cur = log.timestamp.substring(0, idx);
            if(cur.compareTo(lower) >= 0 && cur.compareTo(higher) <= 0) {
                res.add(log.id);
            }
        }

        return res;
    }
}
