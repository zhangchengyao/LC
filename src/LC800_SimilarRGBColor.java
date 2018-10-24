public class LC800_SimilarRGBColor {
    public String similarRGB(String color) {
        return "#"+getSimilar(color.substring(1, 3))+getSimilar(color.substring(3, 5))+getSimilar(color.substring(5));
    }
    private String getSimilar(String color){
        int min = Integer.MAX_VALUE;
        String res = "";
        int[] choice = new int[]{-1, 0, 1};
        char c1 = color.charAt(0);
        char c2 = color.charAt(1);
        for(int v: choice){
            if(v==-1 && c1=='0') continue;
            if(v==1 && c1=='f') continue;
            char c;
            if(c1=='a'&&v==-1) c = '9';
            else if(c1=='9'&&v==1) c = 'a';
            else c = (char)(c1+v);
            int before = (c1>'9'?c1-'a'+10:c1-'0')*16+(c2>'9'?c2-'a'+10:c2-'0');
            int after = (c>'9'?c-'a'+10:c-'0')*16+(c>'9'?c-'a'+10:c-'0');
            int diff = (int)Math.abs(after-before);
            if(diff<min){
                min = diff;
                res = c+""+c;
            }
        }
        return res;
    }
//    public String similarRGB(String color) {
//        int[] choice = new int[]{0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xaa, 0xbb, 0xcc, 0xdd, 0xee, 0xff};
//        return "#"+getSimilar(color.substring(1, 3), choice)+getSimilar(color.substring(3, 5), choice)+getSimilar(color.substring(5), choice);
//    }
//    private String getSimilar(String color, int[] choice){
//        int min = Integer.MAX_VALUE;
//        int res = 0;
//        int value = 0;
//        char c1 = color.charAt(0);
//        char c2 = color.charAt(1);
//        if(c1>'9') value += 16*(c1-'a'+10);
//        else value += 16*(c1-'0');
//        if(c2>'9') value += c2-'a'+10;
//        else value += c2-'0';
//        for(int v: choice){
//            if(Math.pow(value-v, 2)<min){
//                min = (int)Math.pow(value-v, 2);
//                res = v;
//            }
//        }
//        int a = res%16;
//        res /= 16;
//        String hex = "";
//        if(a>9) hex += (char)('a'+a-10);
//        else hex += a;
//        if(res>9) hex = (char)('a'+res-10)+hex;
//        else hex = res+hex;
//        return hex;
//    }
}
