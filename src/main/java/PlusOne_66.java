import java.util.Arrays;

public class PlusOne_66 {

    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {


        for (int i = digits.length - 1; i >= 0; i--) {
            if (++digits[i] - 10 < 0) return digits;
            digits[i] %= 10;
        }

        int[] rs = new int[digits.length + 1];
        rs[0] = 1;
        for (int i = 1; i < rs.length; i++) {
            rs[i] = digits[i - 1];
        }

        return rs;
    }
}
