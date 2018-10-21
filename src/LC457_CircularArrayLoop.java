public class LC457_CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            int next = (i+nums[i]+n)%n;
            if(next==i) continue;
            while(next!=i && nums[next]*nums[i]>0){
                next = (next+nums[next]+n)%n;
                if(visited[next]) break;
                visited[next] = true;
            }
            if(next==i) return true;
        }
        return false;
    }
}
