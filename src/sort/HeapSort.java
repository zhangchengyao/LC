package sort;

public class HeapSort {
    private long[] array;
    private int nElems;

    public HeapSort(int num){
        array = new long[num];
        nElems = 0;
    }

    public void insert(long val){
        array[nElems++] = val;
    }

    public void display(){
        for(int i=0; i<nElems; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort(){
        makeHeap();
        for(int i=0; i<nElems; i++){
            long temp = array[0];
            array[0] = array[nElems-1-i];
            array[nElems-1-i] = temp;
            trickleDown(0, nElems-1-i);
        }
    }

    private void makeHeap(){
        for(int i=nElems/2-1; i>=0; i--){
            trickleDown(i, nElems);
        }
    }

    private void trickleDown(int index, int nElems){
        long top = array[index];
        while(index<nElems/2){
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            int largerChild;
            if(rightChild<nElems && array[rightChild]>array[leftChild]){
                largerChild = rightChild;
            }else{
                largerChild = leftChild;
            }
            if(top<array[largerChild]){
                array[index] = array[largerChild];
                index = largerChild;
            }else{
                break;
            }
        }
        array[index] = top;
    }
}
