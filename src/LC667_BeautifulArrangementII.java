public class LC667_BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int s = 1;
        int b = n;
        int i = 0;
        for(;i<k-1;i++){
            res[i] = (i%2==0?s++:b--);
        }
        if(i%2==0){
            while(s<=b) res[i++] = s++;
        }else{
            while(s<=b) res[i++] = b--;
        }
        return res;
    }
}
