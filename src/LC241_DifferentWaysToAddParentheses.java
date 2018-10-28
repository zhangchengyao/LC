import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC241_DifferentWaysToAddParentheses {
    HashMap<String, List<Integer>> map = new HashMap<>();
    // divide and conquer!
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*'){
                for(Integer a:diffWaysToCompute(input.substring(0,i))){
                    for(Integer b:diffWaysToCompute(input.substring(i+1))){
                        if(input.charAt(i)=='+') res.add(a+b);
                        else if(input.charAt(i)=='-') res.add(a-b);
                        else res.add(a*b);
                    }
                }
            }
        }
        if(res.size()==0) res.add(Integer.parseInt(input));
        map.put(input, res);
        return res;
    }
}
