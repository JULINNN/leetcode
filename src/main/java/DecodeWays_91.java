import java.util.Arrays;

public class DecodeWays_91 {

    public static void main(String[] args) {

//        numDecodings("21012201");

        String test = "10011";

        System.out.println(numDecodings(test));
    }

    public static int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[] rs = new int[s.length()];
        int a0 = (s.charAt(0) - 48);
        int a1 = s.charAt(1) - 48;
        int num = a0 * 10 + a1;

        if(num > 26 && num % 10 == 0)
            return 0;

        rs[0] = 1;

        rs[1] = (num > 26 || num % 10 == 0)  ? 1 : 2;

        if (num > 26) {
            rs[1] = 1;
        } else {
            rs[1] = 2;
        }

        char[] arr = s.toCharArray();

        for (int i = 2; i < arr.length; i++) {
            num = (arr[i - 1] - 48) * 10 + arr[i] - 48;

            if (arr[i] == '0' && (num > 26 || num == 0)) {
                return 0;
            }

            if (arr[i] == '0') {
                rs[i] = rs[i - 2];
                continue;
            }

            if (num <= 26 && arr[i] != '0' && arr[i - 1] != '0') {
                rs[i] = rs[i - 1] + rs[i - 2];

            } else {
                rs[i] = rs[i - 1];

            }
        }
        return rs[rs.length - 1];
    }
}


