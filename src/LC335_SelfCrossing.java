public class LC335_SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        for(int i=3;i<x.length;i++){
            // case 1: 4 -> 1
            if(x[i-1]<=x[i-3] && x[i]>=x[i-2]) return true;
            // case 2: 5 -> 1
            else if(i+1<x.length &&
                    x[i-1]>x[i-3] &&
                    x[i]==x[i-2] &&
                    x[i+1]>=x[i-1]-x[i-3]) return true;
            // case 3: 6 -> 1
            else if(i+2<x.length &&
                    x[i-1]>x[i-3] &&
                    x[i]>x[i-2] &&
                    x[i+1]>=x[i-1]-x[i-3] && x[i+1]<x[i-1] &&
                    x[i+2]>=x[i]-x[i-2]) return true;
        }

        return false;
    }
}
