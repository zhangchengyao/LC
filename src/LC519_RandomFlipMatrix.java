import java.util.HashMap;
import java.util.Random;

public class LC519_RandomFlipMatrix {
    private int n_rows;
    private int n_cols;
    private int remain;
    private HashMap<Integer, Integer> map;
    private Random random;

    public LC519_RandomFlipMatrix(int n_rows, int n_cols) {
        this.n_rows = n_rows;
        this.n_cols = n_cols;
        remain = n_rows * n_cols;
        map = new HashMap<>();
        random = new Random();
    }

    public int[] flip() {
        int num = random.nextInt(remain--);
        int pos = map.getOrDefault(num, num);
        map.put(num, map.getOrDefault(remain, remain));

        return new int[]{pos/n_cols, pos%n_cols};
    }

    public void reset() {
        map.clear();
        remain = n_rows * n_cols;
    }

//    class Coord{
//        int r;
//        int c;
//        Coord(int _r, int _c){
//            r = _r;
//            c = _c;
//        }
//        public int hashCode(){
//            return (r * 31) ^ c;
//        }
//
//        public boolean equals(Object o){
//            if(o instanceof Coord){
//                return r == ((Coord)o).r && c == ((Coord)o).c;
//            }
//            return false;
//        }
//    }
//
//    private int n_rows;
//    private int n_cols;
//    private HashSet<Coord> set;
//
//    public LC519_RandomFlipMatrix(int n_rows, int n_cols) {
//        this.n_rows = n_rows;
//        this.n_cols = n_cols;
//        set = new HashSet<>();
//    }
//
//    public int[] flip() {
//        Random random = new Random();
//        int pos;
//        Coord coord;
//        while(true){
//            pos = random.nextInt(n_rows * n_cols);
//            int row = pos / n_cols;
//            int col = pos % n_cols;
//            coord = new Coord(row, col);
//            if(!set.contains(coord)){
//                set.add(coord);
//                break;
//            }
//        }
//
//        return new int[]{coord.r, coord.c};
//    }
//
//    public void reset() {
//        set.clear();
//    }
}
