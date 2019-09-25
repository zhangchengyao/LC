public class LC780_ReachingPoints {
    // difficult to think of
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx >= sx && ty >= sy) {
            if(tx > ty) {
                tx = tx % ty;
            } else {
                ty = ty % tx;
            }
        }

        if(tx > ty) return tx == sx && (sy - ty) % tx == 0;
        else return ty == sy && (sx - tx) % ty == 0;
    }
}
