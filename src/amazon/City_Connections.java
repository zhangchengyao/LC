package amazon;

import com.sun.tools.internal.xjc.reader.gbind.ConnectedComponent;
import sun.jvm.hotspot.debugger.win32.coff.COFFLineNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class City_Connections {
    static class Connection{
        String node1;
        String node2;
        int cost;

        Connection(String a, String b, int c){
            node1 = a;
            node2 = b;
            cost = c;
        }
    }

    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections){
        if(connections==null || connections.size()==0){
            return new ArrayList<>();
        }

        PriorityQueue<Connection> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        pq.addAll(connections);

        HashMap<String, String> parent = new HashMap<>();
        for(Connection conn: connections){
            if(parent.get(conn.node1)==null) parent.put(conn.node1, conn.node1);
            if(parent.get(conn.node2)==null) parent.put(conn.node2, conn.node2);
        }

        ArrayList<Connection> res = new ArrayList<>();
        int numCities = parent.size();
        for(int i=1;i<numCities;i++){
            while(!pq.isEmpty()){
                Connection conn = pq.poll();
                if(union(conn.node1, conn.node2, parent)){
                    res.add(conn);
                    break;
                }
            }
        }

        if(res.size()==numCities-1) return res;
        else return new ArrayList<>();
    }

    private static boolean union(String a, String b, HashMap<String, String> parent){
        String root1 = parent.get(a);
        String root2 = parent.get(b);
        if(root1.equals(root2)) return false;

        parent.put(root1, root2);
        return true;
    }
    private static String find(String a, HashMap<String, String> parent){
        while(!a.equals(parent.get(a))){
            a = parent.get(a);
        }
        return a;
    }

    public static void main(String[] args) {
        ArrayList<Connection> connections = new ArrayList<>();
        //下面的图是个苯环，中间加上了几根，如果想验证空表，去掉几根线就行。
        connections.add(new Connection("A","B",6));
        connections.add(new Connection("B","C",4));
        connections.add(new Connection("C","D",5));
        connections.add(new Connection("D","E",8));
        connections.add(new Connection("E","F",2));
        connections.add(new Connection("B","F",10));
        connections.add(new Connection("E","C",9));
        connections.add(new Connection("F","C",7));
        connections.add(new Connection("B","E",3));
        connections.add(new Connection("A","F",16));
        //这里就输出一下看看结果。
        ArrayList<Connection> res = getLowCost(connections);
        for (Connection c : res){
            System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
        }
    }
}
