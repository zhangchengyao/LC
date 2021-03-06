import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC767_ReorganizeString {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        char max = 'a';
        for(char c: S.toCharArray()) {
            count[c - 'a']++;
            if(count[c - 'a'] > count[max - 'a']) max = c;
        }

        if(count[max - 'a'] > (S.length() + 1) / 2) return "";

        char[] res = new char[S.length()];
        int i = 0;
        while(count[max - 'a'] > 0) {
            res[i] = max;
            count[max - 'a']--;
            i += 2;
        }

        for(int k = 0; k < count.length; k++) {
            char c = (char)(k + 'a');
            while(count[k] > 0) {
                if(i >= res.length) i = 1;
                res[i] = c;
                i += 2;
                count[k]--;
            }
        }

        return new String(res);
    }

//    class Letter{
//        char c;
//        int num;
//        Letter(char c, int num){
//            this.c = c;
//            this.num = num;
//        }
//    }
//
//    public String reorganizeString(String S) {
//        int[] num = new int[26];
//        for(int i = 0; i < S.length(); i++){
//            num[S.charAt(i) - 'a']++;
//        }
//        int max = 0;
//        int maxNum = 0;
//        StringBuilder maxS = new StringBuilder();
//        for(int i = 0; i < num.length; i++) {
//            if(num[i] > max) max = num[i];
//        }
//        for(int i = 0; i < num.length; i++) {
//            if(num[i] == max){
//                maxS.append((char)('a' + i));
//                maxNum++;
//            }
//        }
//        StringBuilder res = new StringBuilder();
//        if((S.length() - maxNum * max) >= (max - 1)) {
//            PriorityQueue<Letter> maxHeap = new PriorityQueue<>((l1, l2) -> Integer.compare(l2.num, l1.num));
//            for(int i = 0; i < num.length; i++) {
//                if(num[i] != max && num[i] > 0) maxHeap.offer(new Letter((char)('a' + i), num[i]));
//            }
//            for(int i = 0; i < max; i++){
//                res.append(maxS);
//                if(maxHeap.isEmpty()) break;
//                Letter le = maxHeap.poll();
//                res.append(le.c);
//                le.num--;
//                if(le.num > 0) maxHeap.offer(le);
//            }
//            while(!maxHeap.isEmpty()) {
//                ArrayList<Letter> list = new ArrayList<>();
//                while(!maxHeap.isEmpty()){
//                    Letter le = maxHeap.poll();
//                    res.append(le.c);
//                    le.num--;
//                    if(le.num > 0) list.add(le);
//                }
//                for (Letter letter : list) maxHeap.offer(letter);
//            }
//            return res.toString();
//        } else if(S.length() - maxNum * max == 0 && maxNum > 1) {
//            for(int i = 0; i < max; i++){
//                res.append(maxS);
//            }
//            return res.toString();
//        } else return "";
//    }
}
