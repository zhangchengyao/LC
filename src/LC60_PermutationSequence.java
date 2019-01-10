public class LC60_PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) sb.append(i);
        return getPermutation(sb.toString(), k, new int[n+1]);
    }

    private String getPermutation(String str, int k, int[] memo){
        if(k==0){
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
        }
        if(k==1 || str.length()==1) return str;

        int x = str.length()-1;
        if(memo[x]==0) memo[x] = factorial(x);
        int offset = (k-1) / memo[x];

        char first = str.charAt(offset);
        String remain = getPermutation(str.substring(0, offset)+str.substring(offset+1), k%memo[x], memo);

        return first+remain;
    }

    private int factorial(int x){
        int res = 1;
        for(int i=x;i>1;i--) res *= i;
        return res;
    }
}
