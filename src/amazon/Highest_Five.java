package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Highest_Five {
    static class Result{
        int id;
        int value;
        public Result(int id, int value){
            this.id = id;
            this.value = value;
        }
    }

    public static Map<Integer, Double> getHighFive(Result[] results){
        HashMap<Integer, PriorityQueue<Integer>> studentMap = new HashMap<>();
        for(Result result: results){
            studentMap.putIfAbsent(result.id, new PriorityQueue<>());
            studentMap.get(result.id).offer(result.value);
            if(studentMap.get(result.id).size()>5) studentMap.get(result.id).poll();
        }

        Map<Integer, Double> res = new HashMap<>();
        for(int id: studentMap.keySet()){
            PriorityQueue<Integer> values = studentMap.get(id);
            int sum = 0;
            while(!values.isEmpty()) sum += values.poll();
            res.put(id, sum / 5.0);
        }

        return res;
    }

}
