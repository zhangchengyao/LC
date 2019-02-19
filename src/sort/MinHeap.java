package sort;

public class MinHeap {
    private int[] data;
    private int size;

    public MinHeap(int capacity){
        data = new int[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void offer(int x){
        if(size == data.length){
            grow();
        }

        siftUp(size, x);
        size++;
    }

    public Integer poll(){
        if(size == 0){
            return null; // exception
        }

        int res = data[0];

        size--;
        siftDown(0, data[size]);

        return res;
    }

    public Integer peek(){
        if(size == 0){
            return null; // exception
        }

        return data[0];
    }

    private void siftUp(int pos, int val){
        while(pos > 0){
            int parent = (pos - 1) >>> 1;
            if(val < data[parent]){
                data[pos] = data[parent];
                pos = parent;
            } else {
                break;
            }
        }
        data[pos] = val;
    }

    private void siftDown(int pos, int val){
        while((pos << 1) + 1 < size){
            int child = (pos << 1) + 1;
            if(child < size - 1 && data[child + 1] < data[child]){
                child++;
            }

            if(val > data[child]){
                data[pos] = data[child];
                pos = child;
            } else {
                break;
            }
        }
        data[pos] = val;
    }

    private void grow(){
        int[] newData = new int[data.length << 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
