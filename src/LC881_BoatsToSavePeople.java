import java.util.Arrays;

public class LC881_BoatsToSavePeople {
    // two pointers
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        Arrays.sort(people);
        int res = 0;
        while(i < j){
            res++;
            if(people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
        }
        if(i == j) res++;
        return res;
    }
}
