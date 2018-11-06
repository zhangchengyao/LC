import advancedAlgo.Hungarian;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        LC844_BackspaceStringCompare lc = new LC844_BackspaceStringCompare();
//        System.out.println(lc.backspaceCompare("31#","12#"));
        int[][] graph = new int[][]{{1,1,1},{0,1,1},{0,1,1},{0,0,1}};
        Hungarian hungarian = new Hungarian(graph);
        System.out.println(hungarian.hungarian());
    }
    //
}
