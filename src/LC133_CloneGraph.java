import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC133_CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        if(map.containsKey(node.label)) return map.get(node.label);

        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node.label, cloned);
        for(UndirectedGraphNode neighbor: node.neighbors){
            cloned.neighbors.add(dfs(neighbor, map));
        }
        return cloned;
    }
}
