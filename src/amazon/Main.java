package amazon;

import java.util.Map;

import static amazon.Highest_Five.getHighFive;

public class Main {
    public static void main(String[] args) {
        Highest_Five.Result r1 = new Highest_Five.Result(1, 95);
        Highest_Five.Result r2 = new Highest_Five.Result(1, 95);
        Highest_Five.Result r3 = new Highest_Five.Result(1, 91);
        Highest_Five.Result r4 = new Highest_Five.Result(1, 91);
        Highest_Five.Result r5 = new Highest_Five.Result(1, 93);
        Highest_Five.Result r6 = new Highest_Five.Result(1, 105);
        Highest_Five.Result r7 = new Highest_Five.Result(2, 6);
        Highest_Five.Result r8 = new Highest_Five.Result(2, 6);
        Highest_Five.Result r9 = new Highest_Five.Result(2, 7);
        Highest_Five.Result r10 = new Highest_Five.Result(2, 6);
        Highest_Five.Result r11 = new Highest_Five.Result(2, 6);
        Highest_Five.Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);
        System.out.println(res.get(1) + " " + res.get(2));
    }
}
