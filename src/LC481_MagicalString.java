public class LC481_MagicalString {
    // dynamic programming
    public int magicalString(int n) {
        if(n==0) return 0;
        if(n<=3) return 1;
        int[] dp = new int[n];
        dp[0] = 1; dp[1] = 1; dp[2] = 1;
        int group = 2;
        int i = 3;
        while(i<n){
            if(dp[group]==dp[group-1]){
                // position group = '2'
                if(dp[i-1]==dp[i-2]){
                    dp[i] = dp[i-1]+1;
                    i++;
                    if(i==n) break;
                    dp[i] = dp[i-1]+1;
                    i++;
                }else{
                    dp[i] = dp[i-1];
                    i++;
                    if(i==n) break;
                    dp[i] = dp[i-1];
                    i++;
                }
            }else{
                // position group = '1'
                if(dp[i-1]==dp[i-2]){
                    dp[i] = dp[i-1]+1;
                    i++;
                }else{
                    dp[i] = dp[i-1];
                    i++;
                }
            }
            group++;
        }
        return dp[n-1];
    }
    // construct the string first and then count 1's
//    public int magicalString(int n) {
//        StringBuilder sb = new StringBuilder("122");
//        int group = 2;
//        while(sb.length()<n){
//            char c = sb.charAt(group);
//            if(c=='2'){
//                if(sb.charAt(sb.length()-1)=='2') sb.append("11");
//                else sb.append("22");
//            }
//            else{
//                if(sb.charAt(sb.length()-1)=='2') sb.append("1");
//                else sb.append("2");
//            }
//            group++;
//        }
//        int res = 0;
//        for(int i=0;i<n;i++){
//            if(sb.charAt(i)=='1') res++;
//        }
//        return res;
//    }
}
