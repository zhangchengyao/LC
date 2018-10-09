import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args){
        LC685_RedundantConnectionII LC = new LC685_RedundantConnectionII();
        int[][] input = new int[4][2];
        input[0] = new int[]{2,1};
        input[1] = new int[]{3,1};
        input[2] = new int[]{4,2};
        input[3] = new int[]{1,4};
        System.out.println(LC.findRedundantDirectedConnection(input)[0]);;
    }
}
