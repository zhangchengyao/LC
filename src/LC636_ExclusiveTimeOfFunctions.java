import java.util.List;
import java.util.Stack;

public class LC636_ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        for(String log: logs){
            String[] info = log.split(":");
            int id = Integer.parseInt(info[0]);
            int time = Integer.parseInt(info[2]);
            if(info[1].equals("start")){
                if(!stack.isEmpty()) res[stack.peek()] += time-last;
                stack.push(id);
                last = time;
            }
            else{
                res[id] += time-last+1;
                stack.pop();
                last = time+1;
            }
        }
        return res;
    }
}
