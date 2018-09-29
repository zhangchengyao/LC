import java.util.Arrays;
import java.util.HashMap;

public class LC881_BoatsToSavePeople {
    // two pointers
//    public int numRescueBoats(int[] people, int limit) {
//        int i =0;
//        int j = people.length-1;
//        Arrays.sort(people);
//        int res = 0;
//        while(i<j){
//            res++;
//            if(people[i]+people[j]<=limit){
//                i++;
//                j--;
//            }else{
//                j--;
//            }
//        }
//        if(i==j) res++;
//        return res;
//    }
    public int numRescueBoats(int[] people, int limit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<people.length;i++){
            map.put(people[i], map.getOrDefault(people[i], 0)+1);
        }
        int res = 0;
        for(int i=0;i<people.length;i++){
            int weight = people[i];
            if(!map.containsKey(weight)) continue;
            res++;
            map.put(weight, map.get(weight)-1);
            if(map.get(weight)==0) map.remove(weight);
            for(int w=limit-weight;w>=1;w--){
                if(map.containsKey(w)){
                    map.put(w, map.get(w)-1);
                    if(map.get(w)==0) map.remove(w);
                    break;
                }
            }
        }
        return res;
    }
}
