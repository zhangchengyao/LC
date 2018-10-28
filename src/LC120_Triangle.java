import java.util.ArrayList;
import java.util.List;

public class LC120_Triangle {
    // a genius solution
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) return 0;
        int[] dp = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
    // a slow solution
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if(triangle==null || triangle.size()==0) return 0;
//        List<Integer> lastLevel = new ArrayList<>();
//        List<Integer> thisLevel = new ArrayList<>();
//        for(int i=0;i<triangle.size();i++){
//            if(i==0){
//                thisLevel.add(triangle.get(0).get(0));
//            }else{
//                for(int j=0;j<triangle.get(i).size();j++){
//                    if(j==0){
//                        thisLevel.add(lastLevel.get(0)+triangle.get(i).get(j));
//                    }
//                    else if(j==triangle.get(i).size()-1){
//                        thisLevel.add(lastLevel.get(j-1)+triangle.get(i).get(j));
//                    }
//                    else{
//                        thisLevel.add(Math.min(lastLevel.get(j-1), lastLevel.get(j))+triangle.get(i).get(j));
//                    }
//                }
//            }
//            List<Integer> tmp = lastLevel;
//            lastLevel = thisLevel;
//            thisLevel = tmp;
//            thisLevel.clear();
//        }
//        int minTotal = Integer.MAX_VALUE;
//        for(Integer i: lastLevel){
//            if(i<minTotal) minTotal = i;
//        }
//        return minTotal;
//    }
}
