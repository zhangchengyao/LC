public class LC537_ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] aa = a.split("\\+");
        String[] bb = b.split("\\+");
        int real1 = Integer.parseInt(aa[0]);
        int imaginary1 = Integer.parseInt(aa[1].substring(0, aa[1].length() - 1));
        int real2 = Integer.parseInt(bb[0]);
        int imaginary2 = Integer.parseInt(bb[1].substring(0, bb[1].length() - 1));

        int real = real1 * real2 + -1 * imaginary1 * imaginary2;
        int imaginary = real1 * imaginary2 + real2 * imaginary1;
        return real + "+" + imaginary + "i";
    }
}
