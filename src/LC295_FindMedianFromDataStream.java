import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC295_FindMedianFromDataStream {
    PriorityQueue<Integer> minHeap; // store n/2 big numbers
    PriorityQueue<Integer> maxHeap; // store n/2 small numbers
    /** initialize your data structure here. */
    public LC295_FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(11, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
    }

    public void addNum(int num) {
        if(maxHeap.size()==0){
            maxHeap.offer(num);
        }
        else{
            if(maxHeap.size()==minHeap.size()){
                // insert into maxHeap
                int min = minHeap.peek();
                if(min<num){
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }else{
                    maxHeap.offer(num);
                }
            }else{
                // insert into MinHeap;
                int max = maxHeap.peek();
                if(num<max){
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }else{
                    minHeap.offer(num);
                }
            }
        }
    }

    public double findMedian() {
        return maxHeap.size()==minHeap.size()?(maxHeap.peek()+minHeap.peek())/2.0:maxHeap.peek();
    }
    // implementation with arrayList
//    ArrayList<Integer> data;
//    int median1;
//    int median2;
//    int number;
//    /** initialize your data structure here. */
//    public LC295_FindMedianFromDataStream() {
//        data = new ArrayList<>();
//        median1 = -1;
//        median2 = -1;
//        number = 0;
//    }
//
//    public void addNum(int num) {
//        if(number==0){
//            data.add(num);
//            median1 = 0;
//            median2 = 0;
//        }
//        else{
//            int i = 0;
//            if((number&1)==1){
//                // odd number, median1==median2
//                median2++;
//            }else{
//                // even number, median1 = median2-1
//                median1++;
//            }
//            while(i<number && data.get(i)<num) i++;
//            data.add(i, num);
//        }
//        number++;
//    }
//
//    public double findMedian() {
//        return (data.get(median1)+data.get(median2))/2.0;
//    }
}
