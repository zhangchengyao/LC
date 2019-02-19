import advancedAlgo.Hungarian;
import advancedAlgo.KM;
import sort.MinHeap;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap(2);
        mh.offer(3);
        mh.offer(1);
        mh.offer(29);
        mh.offer(11);
        mh.offer(5);
        while(!mh.isEmpty()){
            System.out.println(mh.poll());
        }
//        LC488_ZumaGame test = new LC488_ZumaGame();
//        System.out.println(test.update("BYYBB", 1, 'Y'));
//        int[][] graph = new int[][]{{3,0,4,0},{2,1,3,0},{0,0,5,0},{0,0,4,3}};
//        KM km = new KM(graph);
//        System.out.println(km.KM());
//        String a = "/f/f";
//        String[] e = a.split("/");
//        System.out.println(e.length);
    }
    // 792， 72
    // premium: 360，291
}
