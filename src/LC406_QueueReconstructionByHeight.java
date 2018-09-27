import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?Integer.compare(o1[1],o2[1]):Integer.compare(o2[0],o1[0]);
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<people.length;i++){
            list.add(people[i][1], people[i]);
        }
        list.toArray(people);
        return people;
    }
}
