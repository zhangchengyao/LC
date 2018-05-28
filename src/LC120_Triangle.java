import java.util.ArrayList;
import java.util.List;

public class LC120_Triangle {
    // a slow solution
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) return 0;
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0;i<triangle.size();i++){
            dp.add(new ArrayList<Integer>());
            if(i==0){
                dp.get(i).add(triangle.get(0).get(0));
                continue;
            }
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0){
                    dp.get(i).add(dp.get(i-1).get(0)+triangle.get(i).get(j));
                }
                else if(j==triangle.get(i).size()-1){
                    dp.get(i).add(dp.get(i-1).get(j-1)+triangle.get(i).get(j));
                }
                else{
                    dp.get(i).add(Math.min(dp.get(i-1).get(j-1), dp.get(i-1).get(j))+triangle.get(i).get(j));
                }
            }
        }
        int minTotal = Integer.MAX_VALUE;
        for(Integer i: dp.get(dp.size()-1)){
            if(i<minTotal) minTotal = i;
        }
        return minTotal;
    }
}
