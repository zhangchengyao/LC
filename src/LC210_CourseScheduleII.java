import java.util.ArrayList;
import java.util.Stack;

public class LC210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] V = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) V[i] = new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++) V[prerequisites[i][1]].add(prerequisites[i][0]);
        int num = numCourses;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V.length;i++){
            if(V[i]!=null && V[i].size()==0){
                for(int j=0;j<V.length;j++){
                    if(V[j]==null || j==i) continue;
                    if(V[j].contains(i)) V[j].remove((Integer)i);
                }
                stack.push(i);
                V[i] = null;
                num--;
                i = -1;
            }
        }
        if(num!=0) return new int[]{};
        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++) res[i] = stack.pop();
        return res;
    }
}
