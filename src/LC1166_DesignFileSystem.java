import java.util.HashMap;

public class LC1166_DesignFileSystem {
    private HashMap<String, Integer> paths;

    public LC1166_DesignFileSystem() {
        paths = new HashMap<>();
        paths.put("", 0);
    }

    public boolean createPath(String path, int value) {
        if(path == null || path.length() < 2 || paths.containsKey(path)) return false;

        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if(!paths.containsKey(parent)) return false;
        paths.put(path, value);

        return true;
    }

    public int get(String path) {
        return paths.get(path) == null ? -1 : paths.get(path);
    }
}
