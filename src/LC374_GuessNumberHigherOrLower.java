public class LC374_GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid;
        while(low<=high){
            mid = low+(high-low)/2;
            int res = guess(mid);
            if(res==0) return mid;
            else if(res==-1) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
    private int guess(int num){
        int pick = (int)(num*Math.random());
        if(num>pick) return 1;
        else if(num==pick) return 0;
        else return -1;
    }
}
