import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        LC140_WordBreakII lc = new LC140_WordBreakII();
        String[] arr = new String[]{"cat","cats","and","sand","dog"};
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++) list.add(arr[i]);
        lc.wordBreak("catsanddog", list);
    }
}
