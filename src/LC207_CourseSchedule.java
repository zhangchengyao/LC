import java.util.ArrayList;

public class LC207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] vertices = new ArrayList[numCourses];
        for(int i=0;i<vertices.length;i++) vertices[i] = new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++){
            vertices[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int num = numCourses;
        for(int i=0;i<vertices.length;i++){
            if(vertices[i]!=null && vertices[i].size()==0){
                for(int j=0;j<vertices.length;j++){
                    if(j==i || vertices[j]==null) continue;
                    if(vertices[j].contains(i)) vertices[j].remove((Integer)i);
                }
                vertices[i] = null;
                num--;
                i = -1;
            }
        }
        return num==0;
    }
}
