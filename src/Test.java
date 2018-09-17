public class Test {
    public static void main(String[] args){
        int left = 1;
        int right = 21210000;
        for(int i=left;i<right;i++){
            int n1 = (left+right)/2;
            int n2 = left + (right-left)/2;
            if(n1!=n2){
                System.out.println("Current i = "+i);
                System.out.println("n1 = "+n1+" n2 = "+n2);
            }
        }
    }
}
