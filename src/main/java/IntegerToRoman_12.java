public class IntegerToRoman_12 {


    private static int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000, 5000};
    private static String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};


    public static void main(String[] args) {
        System.out.println(intToRoman(1988));
    }


    public static String intToRoman(int num) {

        StringBuilder stb = new StringBuilder();

        int digit = 1;
        int j = 0;

        while (num != 0) {
            int c = (num % 10) * digit;
            num /= 10;
            digit *= 10;

            if (c == 0) {
                continue;
            }

            while (c > nums[j] && c >= nums[j + 1]) {
                j++;
            }
            stb.append(getSymbols(c, j, digit / 10));
        }

        return stb.reverse().toString();

    }

    private static String getSymbols(int c, int j, int digit) {

        String symbol = "";

        switch (digit) {
            case 1:
                symbol = symbols[0];
                break;
            case 10:
                symbol = symbols[4];
                break;
            case 100:
                symbol = symbols[8];
                break;
            case 1000:
                symbol = symbols[12];
                break;
        }

        StringBuilder stb = new StringBuilder();
        if (c == nums[j]) {
            return stb.append(symbols[j]).reverse().toString();

        }

        stb.append(symbols[j]);

        for (int i = c - nums[j]; c > nums[j]; c -= digit) {
            stb.append(symbol);
        }

        return stb.reverse().toString();

    }
}
