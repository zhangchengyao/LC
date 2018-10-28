package sort;

public class ShellSort {
    private long[] array;
    private int nElems;

    public ShellSort(int num){
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
        int gap = 1;
        while((3*gap+1) < nElems){
            gap = 3 * gap + 1;
        }
        while(gap>0){
            for(int out=gap; out<nElems; out++){
                int in = out;
                long temp = array[out];
                while(in>=gap && array[in-gap]>temp){
                    array[in] = array[in-gap];
                    in -= gap;
                }
                array[in] = temp;
            }
            gap = (gap - 1) / 3;
        }
    }
}
