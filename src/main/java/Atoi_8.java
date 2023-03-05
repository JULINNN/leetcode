public class Atoi_8 {


    static int[] vaildAscii = {43, 45, 48, 49, 50, 51, 52, 53, 54, 55};

    public static void main(String[] args) {
        System.out.println(myAtoi(
                ".1"));
    }

    public static int myAtoi(String s) {
        boolean isPositive = true;
        long rs = 0;
        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            long value = s.charAt(i) - 48;
            if (i == 0 && (value == -5 || value == -3)) {
                isPositive = value == -5;
                continue;
            }
            if ((value > 9 || value < 0))
                break;

            if (isPositive)
                rs = rs * 10 + value;
            else
                rs = rs * 10 - value;

            if (isPositive && rs > Integer.MAX_VALUE) {
                rs = Integer.MAX_VALUE;
                break;
            }
            if (!isPositive && rs < Integer.MIN_VALUE) {
                rs = Integer.MIN_VALUE;
                break;
            }

        }

        return (int) rs;
    }
}
