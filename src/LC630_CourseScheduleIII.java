import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC630_CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return ((Integer)a[1]).compareTo((Integer)b[1]);
            }
        });
        int days = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(courses.length/2+1, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b.compareTo(a);
            }
        });
        for(int i=0;i<courses.length;i++){
            days += courses[i][0];
            maxHeap.offer(courses[i][0]);
            if(days>courses[i][1]){
                days -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }
}
