import java.util.HashMap;

public class LC399_EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Double> value = new HashMap<>();
        double[] res = new double[queries.length];
        for(int i=0;i<values.length;i++){
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            if(!value.containsKey(s1) && !value.containsKey(s2)){
                parent.put(s1, s1);
                parent.put(s2, s1);
                value.put(s1, values[i]);
                value.put(s2, 1.0);
            }
            else if(!value.containsKey(s2)){
                parent.put(s2, s1);
                value.put(s2, value.get(s1)/values[i]);
            }
            else if(!value.containsKey(s1)){
                parent.put(s1, s2);
                value.put(s1, value.get(s2)*values[i]);
            }
            else{
                union(s1, s2, parent, values[i], value);
            }
        }
        for(int i=0;i<queries.length;i++){
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            if(!value.containsKey(s1) || !value.containsKey(s2) || !find(s1, parent).equals(find(s2, parent))) res[i] = -1.0;
            else res[i] = value.get(s1)/value.get(s2);
        }
        return res;
    }
    private String find(String s, HashMap<String, String> parent){
        while(!s.equals(parent.get(s))) s = parent.get(s);
        return s;
    }
    private void union(String s1, String s2, HashMap<String, String> parent, double val, HashMap<String, Double> value){
        String root1 = find(s1, parent);
        String root2 = find(s2, parent);
        if(root1.equals(root2)) return;
        double coeff = (value.get(s2)*val)/value.get(s1);
        for(String str: value.keySet()){
            if(find(str, parent).equals(root1)) value.put(str, value.get(str)*coeff);
        }
        parent.put(root2, root1);
    }
}
