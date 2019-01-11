import java.util.HashMap;

public class LC149_MaxPointsOnALine {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    class Slope{
        int deltay;
        int deltax;
        Slope(int y, int x){
            deltay = y;
            deltax = x;
        }

        public boolean equals(Object o){
            if(o instanceof Slope){
                return deltay==((Slope)o).deltay && deltax==((Slope)o).deltax;
            }
            return false;
        }
        public int hashCode(){
            return (deltay*31) ^ deltax;
        }
    }

    public int maxPoints(Point[] points) {
        if(points.length<3) return points.length;

        int max = 0;
        for(int i=0;i<points.length;i++){
            int samePoint = 0;
            int localMax = 0;
            HashMap<Slope,Integer> counts = new HashMap<>();
            for(int j=0;j<points.length;j++){
                int deltay = points[j].y - points[i].y;
                int deltax = points[j].x - points[i].x;
                if(deltay==0 && deltax==0){
                    samePoint++;
                } else {
                    int gcd = gcd(deltay, deltax);
                    deltay /= gcd;
                    deltax /= gcd;
                    Slope slope = deltax==0?new Slope(Integer.MAX_VALUE, Integer.MAX_VALUE):new Slope(deltay, deltax);
                    counts.put(slope, counts.getOrDefault(slope, 0)+1);
                    localMax = Math.max(localMax, counts.get(slope));
                }
            }
            if(localMax+samePoint>max) max = localMax+samePoint;
        }

        return max;
    }


    private int gcd(int a, int b){
        while(b!=0){
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
