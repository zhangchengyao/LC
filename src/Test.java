import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        LC155_MinStack obj = new LC155_MinStack();
         obj.push(512);
         obj.push(-1024);
         obj.push(-1024);
         obj.push(512);
         obj.pop();
         obj.show();
        System.out.println();
         obj.pop();
         obj.show();
        System.out.println();
         obj.pop();
         obj.show();
    }
}
