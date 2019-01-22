public class LC517_SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int total = getTotalNum(machines);
        int n = machines.length;
        if(total%n!=0) return -1;
        int target = total / n;

        int move = 0;
        int[] count = new int[n];
        for(int i=0;i<n;i++){
            count[i] = (i==0?0:count[i-1]) + machines[i];
        }

        for(int i=0;i<n;i++){
            if(machines[i]>target){
                int left = i==0?0:target*i-count[i-1];
                int curMove = 0;
                if(left>0){
                    curMove = left;
                    machines[i] -= left;
                }

                int diff = machines[i] - target;
                if(diff>0){
                    curMove += diff;
                    machines[i+1] += diff;
                    count[i] -= diff;
                }

                move = Math.max(move, curMove);
            }
        }

        return move;
    }

    // TLE solution
//    public int findMinMoves(int[] machines) {
//        int total = getTotalNum(machines);
//        int n = machines.length;
//        if(total%n!=0) return -1;
//        int target = total / n;
//
//        boolean finish = false;
//        int move = 0;
//        while(!finish){
//            finish = true;
//            int[] count = new int[n];
//            for(int i=0;i<n;i++){
//                count[i] = (i==0?0:count[i-1]) + machines[i];
//            }
//
//            for(int i=0;i<n;i++){
//                int left = i==0?0:target*i-count[i-1];
//                if(left>0 && machines[i]>0){
//                    machines[i]--;
//                    machines[i-1]++;
//                    count[i-1]++;
//                    finish = false;
//                } else if(machines[i]>target) {
//                    machines[i]--;
//                    machines[i+1]++;
//                    count[i]--;
//                    finish = false;
//                }
//            }
//            if(!finish) move++;
//        }
//
//        return move;
//    }

    private int getTotalNum(int[] machines){
        int sum = 0;
        for(int num: machines) sum += num;
        return sum;
    }
}
