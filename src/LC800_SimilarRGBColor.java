import java.util.TreeSet;

public class LC800_SimilarRGBColor {
    public String similarRGB(String color) {
        return "#" + getSimilar(color.substring(1, 3)) + getSimilar(color.substring(3, 5)) + getSimilar(color.substring(5));
    }
    private String getSimilar(String color){
        int min = Integer.MAX_VALUE;
        String res = "";
        int[] choice = new int[]{-1, 0, 1};
        char c1 = color.charAt(0);
        char c2 = color.charAt(1);
        for(int v: choice){
            if(v == -1 && c1 == '0') continue;
            if(v == 1 && c1 == 'f') continue;

            char c;
            if(c1 == 'a' && v == -1) c = '9';
            else if(c1 == '9' && v == 1) c = 'a';
            else c = (char)(c1 + v);
            int before = (c1 > '9' ? c1 - 'a' + 10 : c1 - '0') * 16 + (c2 > '9' ? c2 - 'a' + 10 : c2 - '0');
            int val = c > '9' ? c - 'a' + 10 : c - '0';
            int after = val * 16 + val;
            int diff = Math.abs(after - before);
            if(diff < min){
                min = diff;
                res = c + "" + c;
            }
        }
        return res;
    }

//    public String similarRGB(String color) {
//        TreeSet<Integer> tset = new TreeSet<>();
//        for(int i = 0; i < 16; i++) {
//            tset.add(i * 16 + i);
//        }
//
//        StringBuilder sb = new StringBuilder("#");
//        for(int i = 1; i < color.length(); i += 2) {
//            char c1 = color.charAt(i);
//            char c2 = color.charAt(i + 1);
//            int a = c1 < 'a' ? c1 - '0' : c1 - 'a' + 10;
//            int b = c2 < 'a' ? c2 - '0' : c2 - 'a' + 10;
//
//            int cur = a * 16 + b;
//            Integer low = tset.floor(cur);
//            Integer high = tset.ceiling(cur);
//            if(low == null || (high != null && cur - low > high - cur)) {
//                a = high / 16;
//                b = high % 16;
//
//            } else {
//                a = low / 16;
//                b = low % 16;
//            }
//            sb.append((char) (a < 10 ? a + '0' : 'a' + (a - 10))).append((char) (b < 10 ? b + '0' : 'a' + (b - 10)));
//        }
//        return sb.toString();
//    }
}
