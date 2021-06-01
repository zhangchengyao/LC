public class LC278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
    private boolean isBadVersion(int version) { return false; }
}
