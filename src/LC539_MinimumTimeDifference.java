import java.util.List;
import java.util.TreeSet;

public class LC539_MinimumTimeDifference {
    private static final int period = 24 * 60;

    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        TreeSet<Integer> tset = new TreeSet<>();

        for(String time: timePoints){
            int t = convert(time);

            if(tset.contains(t)) return 0;

            if(tset.higher(t)!=null) min = Math.min(min, tset.higher(t) - t);
            if(tset.lower(t)!=null) min = Math.min(min, t - tset.lower(t));

            tset.add(t);
        }
        return Math.min(min, tset.first() + period - tset.last());
    }

    private int convert(String time){
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h * 60 + m;
    }

//    public int findMinDifference(List<String> timePoints) {
//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i < timePoints.size(); i++){
//            for(int j = i + 1; j < timePoints.size(); j++){
//                int curMin = calculateDiff(timePoints.get(i), timePoints.get(j));
//                if(curMin < min) min = curMin;
//                if(min==0) return 0;
//            }
//        }
//        return min;
//    }
//
//    private int calculateDiff(String time1, String time2){
//        String[] t1 = time1.split(":");
//        String[] t2 = time2.split(":");
//
//        int h1 = Integer.parseInt(t1[0]);
//        int m1 = Integer.parseInt(t1[1]);
//        int h2 = Integer.parseInt(t2[0]);
//        int m2 = Integer.parseInt(t2[1]);
//
//        int diff = (h1 - h2) * 60 + m1 - m2;
//        if(diff<0) return Math.min(Math.abs(diff), diff + period);
//        else return Math.min(Math.abs(diff-period), diff);
//    }
}
