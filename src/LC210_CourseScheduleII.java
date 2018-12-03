import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] V = new ArrayList[numCourses];
        int[] in = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            if(V[prerequisites[i][1]]==null) V[prerequisites[i][1]] = new ArrayList<>();
            V[prerequisites[i][1]].add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        int[] res = new int[numCourses];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            res[idx++] = cur;
            if(V[cur]!=null){
                for(int to: V[cur]){
                    in[to]--;
                    if(in[to]==0) q.offer(to);
                }
            }
        }
        for(int i=0;i<in.length;i++){
            if(in[i]!=0) return new int[]{};
        }
        return res;
    }

//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        ArrayList<Integer>[] V = new ArrayList[numCourses];
//        for(int i=0;i<numCourses;i++) V[i] = new ArrayList<>();
//        for(int i=0;i<prerequisites.length;i++) V[prerequisites[i][1]].add(prerequisites[i][0]);
//        int num = numCourses;
//        Stack<Integer> stack = new Stack<>();
//        for(int i=0;i<V.length;i++){
//            if(V[i]!=null && V[i].size()==0){
//                for(int j=0;j<V.length;j++){
//                    if(V[j]==null || j==i) continue;
//                    if(V[j].contains(i)) V[j].remove((Integer)i);
//                }
//                stack.push(i);
//                V[i] = null;
//                num--;
//                i = -1;
//            }
//        }
//        if(num!=0) return new int[]{};
//        int[] res = new int[numCourses];
//        for(int i=0;i<numCourses;i++) res[i] = stack.pop();
//        return res;
//    }
}
